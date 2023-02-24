package com.jad.chessknight;

public class HexagonalBoard<Data extends Square> extends Board<Data> {


    public HexagonalBoard(final int height, final int width)
    {
        super(height, width);
        int mid = height / 2; // Calcul du milieu de la hauteur de l'héxagone
        int countSquare = 0; // Compte le nombre de case
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // Dans la partie supérieur du tableau et que je ne suis pas dans la partie central je créer mes cases
                if (i < mid && (j < mid - i || j >= mid + i + 1))
                {
                    this.putAt(j, i, (Data) new Square(countSquare));
                    countSquare++;
                }
                // Dans la partie inférieur du tableau
                else if (i > mid && (j < i - mid || j >= width - (i - mid)))
                {
                    this.putAt(j, i, (Data) new Square(countSquare));
                    countSquare++;
                }
                //Dans le milieu du tableau
                else
                {
                    this.putAt(j, i, (Data) new Square(countSquare));
                    countSquare++;
                }
            }
        }
    }

    //Je n'arrive pas à centrer mon héxagone comme je voudrais
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        //Hauteur de l'héxagone divisé par deux
        int mid = this.getHeight() / 2;

        //Boucle sur la hauteur
        for (int i = 0; i < this.getHeight(); i++) {

            //Calcul de l'espace pour pouvoir centrer les lignes (Calcul la différence entre la ligne actuelle et la ligne mid de réfèrence)
            int spacing = mid - Math.abs(mid - i);

            //Ajoute des espace en début de ligne
            for (int j = 0; j < spacing; j++)
            {
                result.append("\t");
            }

            //Ajoute chaque élement sapré d'un espace
            for (int j = 0; j < this.getWidth(); j++)
            {
                result.append(this.getAt(j, i)).append("\t");
            }

            //Descend à la ligne suivante (retour chariot)
            result.append("\n");
        }

        return result.toString();
    }
}