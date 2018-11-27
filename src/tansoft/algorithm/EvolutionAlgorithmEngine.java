package tansoft.algorithm;

import tansoft.algorithm.ga.Mutation;
import tansoft.algorithm.ga.Selection;
import tansoft.algorithm.operators.Crossover;

public class EvolutionAlgorithmEngine {

    public static final int DEFAULT_VISUALIZATION_UPDATE_PERIOD = 50;
    public static final boolean DEFAULT_LOGGING_ENABLED = true;

    private int populationSize;
    private float mutationRate;
    private float crossoverRate;
    protected Mutation.Type mutationType;
    private Crossover.Type crossoverType;
    private Selection.Type selectionType;
}
