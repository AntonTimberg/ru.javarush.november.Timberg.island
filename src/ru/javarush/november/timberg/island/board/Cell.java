package ru.javarush.november.timberg.island.board;

import ru.javarush.november.timberg.island.lifeform.Organism;
import ru.javarush.november.timberg.island.lifeform.Plant;
import ru.javarush.november.timberg.island.lifeform.State;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;
import ru.javarush.november.timberg.island.lifeform.animals.herbivores.*;
import ru.javarush.november.timberg.island.lifeform.animals.predators.*;
import ru.javarush.november.timberg.island.utils.Randomizer;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Cell {

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
            var maxAnimalPopulation = (createAnimal(animalType).getMaxPopulation());
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

    public void grassGrowth(Cell cell) {
        int count = 0;

        if (count < PLANTS_MAX_POPULATION) {
            for (int i = 0; i < (Randomizer.getRandom(0, (PLANTS_MAX_POPULATION - count))); i++) {
                cell.getPlants().add(new Plant());
            }
        }
    }

    public static Organism createAnimal(AnimalType animal) {
        switch (animal) {
            case WOLF:
                return new Wolf();
            case BEAR:
                return new Bear();
            case EAGLE:
                return new Eagle();
            case FOX:
                return new Fox();
            case BOA:
                return new Boa();
            case BOAR:
                return new Boar();
            case BUFFALO:
                return new Buffalo();
            case DEER:
                return new Deer();
            case RABBIT:
                return new Rabbit();
            case DUCK:
                return new Duck();
            case GOAT:
                return new Goat();
            case HORSE:
                return new Horse();
            case MOUSE:
                return new Mouse();
            case SHEEP:
                return new Sheep();
            case CATERPILLAR:
                return new Caterpillar();
            default:
                throw new IllegalStateException("Invalid animal: " + animal);
        }
    }

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
