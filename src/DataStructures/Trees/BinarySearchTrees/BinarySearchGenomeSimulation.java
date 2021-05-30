package DataStructures.Trees.BinarySearchTrees;

import DataStructures.Trees.Common.ElementNotInTreeException;
import DataStructures.Trees.Common.EmptyTreeException;

public class BinarySearchGenomeSimulation {

    public static void main(String[] args) throws ElementNotInTreeException, EmptyTreeException {
        BinarySearchTree<Genome> genomeTree = new BinarySearchTree<>();

        //Datos Inventados
        Genome megavirus = new Genome("AABCD","virus","Virus de ADN bicatenario", 10);
        Genome influenza = new Genome("AAXFQ","bacteria","Resopnsable de la meningitis, epiglotitis y neumonia", 8);
        Genome thaliana = new Genome("PEAAT","planta","Planta encontrada en asia america, australia y partes de africa", 15);
        Genome nidulans = new Genome("HOFUN","hongo","Organismo de estudio en celulas eucariotas", 20);
        Genome homoSapiens = new Genome("MAMHS","mamifero","Genoma del humano", 9);

        //Genoma no presente en el arbol. Usado para testear el metodo search cuando no hay ningun elemento que coincida
        Genome VirusPrueba = new Genome("AAAAA", "VirusPrueba", "Este es un virus de prueba que no debe encontrarse en el arbol", 90);

        genomeTree.insert(megavirus);
        genomeTree.insert(influenza);
        genomeTree.insert(thaliana);
        genomeTree.insert(nidulans);
        genomeTree.insert(homoSapiens);

        System.out.println("Creamos un arbol de genomas que estan ordenados por su codigo de genoma. Los comparamos alfabeticamente usando un comparator");
        System.out.println("----------------------------");


        System.out.println("Buscar el genoma de la influenza e imprimir su codigo: " + genomeTree.search(influenza).getOrganism_Code());
        System.out.println("----------------------------");


        System.out.println("Maximo elemento del arbol: " + genomeTree.getMax().getOrganism_Code());
        System.out.println("----------------------------");


        System.out.println("Minimo elemento del arbol: " + genomeTree.getMin().getOrganism_Code());
        System.out.println();

        System.out.println("Existe algun genoma con el codigo AAAAA? ");
        try {
          genomeTree.search(VirusPrueba);
        } catch (ElementNotInTreeException e ){
            System.out.println("No hay ningun genoma con codigo AAAAA en el arbol");
        }

    }
}
