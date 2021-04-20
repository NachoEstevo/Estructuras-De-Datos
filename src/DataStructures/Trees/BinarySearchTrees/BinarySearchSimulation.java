package DataStructures.Trees.BinarySearchTrees;

import DataStructures.Trees.Common.ElementNotInTreeException;
import DataStructures.Trees.Common.EmptyTreeException;

public class BinarySearchSimulation {

    public static void main(String[] args) throws ElementNotInTreeException, EmptyTreeException {
        BinarySearchTree<Genome> genomeTree = new BinarySearchTree<>();

        //Datos Inventados
        Genome megavirus = new Genome("AABCD","virus","Virus de ADN bicatenario", 1);
        Genome influenza = new Genome("AAXFQ","bacteria","Resopnsable de la meningitis, epiglotitis y neumonia", 1);
        Genome thaliana = new Genome("PEAAT","planta","Planta encontrada en asia america, australia y partes de africa", 135);
        Genome nidulans = new Genome("HOFUN","hongo","Organismo de estudio en celulas eucariotas", 30);
        Genome homoSapiens = new Genome("MAMHS","mamifero","Genoma del humano", 3300);

        genomeTree.insert(megavirus);
        genomeTree.insert(influenza);
        genomeTree.insert(thaliana);
        genomeTree.insert(nidulans);
        genomeTree.insert(homoSapiens);

        System.out.println(genomeTree.search(megavirus).getOrganism_Code());
        System.out.println(genomeTree.getMax().getOrganism_Code());
    }
}
