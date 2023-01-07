package ru.javarush.november.timberg.island.board;

import ru.javarush.november.timberg.island.lifeform.Organism;
import ru.javarush.november.timberg.island.lifeform.Plant;
import ru.javarush.november.timberg.island.lifeform.State;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;
import ru.javarush.november.timberg.island.lifeform.animals.herbivores.Rabbit;
import ru.javarush.november.timberg.island.lifeform.animals.predators.Boa;
import ru.javarush.november.timberg.island.lifeform.animals.predators.Wolf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;


public class Cell {
    private static final Map<AnimalType, Integer> MAX_ANIMAL_POPULATIONS = Map.of(
            AnimalType.WOLF, WOLF_MAX_POPULATION, AnimalType.RABBIT, RABBIT_MAX_POPULATION,
            AnimalType.BOA, BOA_MAX_POPULATION, AnimalType.BOAR, BOAR_MAX_POPULATION,
            AnimalType.EAGLE, EAGLE_MAX_POPULATION, AnimalType.HORSE, HORSE_MAX_POPULATION,
            AnimalType.DEER, DEER_MAX_POPULATION, AnimalType.BUFFALO, BUFFALO_MAX_POPULATION,
            AnimalType.MOUSE, MOUSE_MAX_POPULATION, AnimalType.GOAT, GOAT_MAX_POPULATION
            );

    private final List<Animal> animals = new CopyOnWriteArrayList<>();
    private final List<Plant> plants = new CopyOnWriteArrayList<>();

    private List<Cell> nearestCells = new ArrayList<>();

    public Cell(List<Organism> organisms) {
        for (Organism organism : organisms) {
            if (organism instanceof Animal) {
                animals.add((Animal) organism);
            } else {
                plants.add((Plant) organism);
            }
        }
    }

    public void addNearestCell(Cell nearestCell) {
        nearestCells.add(nearestCell);
    }

    public List<Cell> getNearestCells() {
        return nearestCells;
    }

    public static Cell create() {
        var organisms = new ArrayList<Organism>();
        var random = new Random();

        for (var animalType : AnimalType.values()) {
            var maxAnimalPopulation = MAX_ANIMAL_POPULATIONS.get(animalType);
            var animalCount = random.nextInt(maxAnimalPopulation);

            Stream.generate(() -> Cell.createAnimal(animalType))
                    .limit(animalCount)
                    .forEach(organisms::add);
        }

        var plantCount = random.nextInt(PLANTS_MAX_POPULATION);

        Stream.generate(Plant::new)
                .limit(plantCount)
                .forEach(organisms::add);

        return new Cell(organisms);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public List<Organism> getOrganisms() {
        List<Organism> organisms = new ArrayList<>();

        organisms.addAll(animals);
        organisms.addAll(plants);

        return organisms;
    }

//    public void grassGrowth(Cell cell) {
//        ArrayList<Organism> cellList = new ArrayList<>(cell.getCell());
//
//        Plant plant = new Plant();
//        int count = 0;
//
//        for (Organism animal : cellList) {
//            Class clazz = animal.getClass();
//            if (clazz.equals(Plant.class)) count++;
//        }
//
//        if (count < plant.getMaxPopulation()) {
//            for (int i = 0; i < (randomNumber.nextInt((int) plant.getMaxPopulation()) * POPULATION_RATE); i++) {
//                this.cell.add(new Plant());
//            }
//        }
//    }


//    public synchronized void reproduction(Cell cell) {
//        ArrayList<Organism> cellList = new ArrayList<>(cell.getCell());
//        ArrayList<Class> classArray = new ArrayList<>();
//
//        for (Object animal : cellList) {
//            Class clazz = animal.getClass();
//            if (clazz.equals(Plant.class)) continue;
//            classArray.add(clazz);
//        }
//
//        for (Organism animal : cellList) {
//            int count;
//            Class clazz = animal.getClass();
//            if (clazz.equals(Plant.class)) continue;
//            count = (int) classArray.stream().filter(clazz::equals).count();
//            if ((count < animal.getMaxPopulation()) && (count >= 2) && (animal.getCurrentWeight() > (animal.getMaxWeight() * WEIGHT_INDEX_REPRODUCTION))) {
//                innerReproduction(clazz);
//            }
//        }
//    }

//    void innerReproduction(Class clazz) {
//        for (AnimalType animal : ANIMAL_TYPE_ENUM) {
//            Organism currentObject = createAnimal(animal);
//            if (clazz.equals(currentObject.getClass())) {
//                this.cell.add(currentObject);
//            }
//        }
//    }

    public static Organism createAnimal(AnimalType animal) {
        switch (animal) {
            case WOLF:
                return new Wolf();
            case RABBIT:
                return new Rabbit();
            case BOA:
                return new Boa();
            default:
                throw new IllegalStateException("Invalid animal: " + animal);
        }
    }

//    @Override
//    public String toString() {
//        return "Cell{" + "cell=" + cell.toString() + '}';
//    }

    public void remove(Set<Organism> organisms) {
        animals.removeIf(organisms::contains);
        plants.removeIf(organisms::contains);
    }

    public void add(Set<Organism> organisms) {
        organisms.forEach(this::add);
    }

    public void add(Organism organism) {
        if (organism instanceof Animal) {
            add((Animal) organism);
        } else {
            add((Plant) organism);
        }
    }

    public void add(Animal animal) {
        animals.add(animal);
    }

    public void add(Plant plant) {
        plants.add(plant);
    }


    public void markDead(Set<Organism> organisms) {
        for (Plant plant : plants) {
            if (organisms.contains(plant)) {
                plant.setState(State.DEAD);
            }
        }

        for (Animal animal : animals) {
            if (organisms.contains(animal)) {
                animal.setState(State.DEAD);
            }
        }
    }
}
