/**
 * This class is used to design polynomial representation
 * @author Rajendra Singh Rathore
 *
 */

package adt_cdt;

public final class Poly {

    final int[][] polynomial;
    final int noOfTerms;

    /**
     * Public constructor
     * 
     * @param powers
     */
    public Poly(int[][] input) {
        polynomial = removeDuplicate(input);
        noOfTerms = polynomial.length;
    }

    /**
     * Evaluate the value of the polynomial
     * 
     * @param valueOfVariable
     * @return totalValue
     */
    public float evaluate(float valueOfVariable) {
        float totalValue = 0.0F;

        for (int i = 0; i < noOfTerms; i++) {
            totalValue += ((float) (Math.pow(valueOfVariable, polynomial[i][0])) * polynomial[i][1]);
        }
        return totalValue;
    }

    public static int[][] removeDuplicate(int[][] input) {
        if (input.length <= 0) {
            System.out.println("There is no items available.");
            return input;
        } else {
            int terms = input.length;
            int[][] inputPoly = input;
            for (int i = 0; i < inputPoly.length - 1; i++) {
                for (int j = i + 1; j < inputPoly.length; j++) {
                    if (inputPoly[i][0] != -1 && inputPoly[i][0] == inputPoly[j][0]) {
                        inputPoly[i][1] += inputPoly[j][1];
                        inputPoly[j][0] = -1;
                        inputPoly[j][1] = -1;
                        terms--;
                    }
                }
            }
            
            int[][] processedArray = new int[terms][2];
            int pointer = 0;
            for (int i = 0; i < inputPoly.length; i++) {
                if (inputPoly[i][0] != -1) {
                    processedArray[pointer][0] = inputPoly[i][0];
                    processedArray[pointer++][1] = inputPoly[i][1];
                }
            }
            return processedArray;
        }
    }

    /**
     * Get the degree of the polynomial
     * 
     * @return degree
     */
    public int degree() {
        int degree = 0;
        for (int i = 0; i < noOfTerms; i++) {
            if (polynomial[i][0] > degree) {
                degree = polynomial[i][0];
            }
        }
        return degree;
    }

    /**
     * Add the two given polynomials
     * 
     * @param poly1
     * @param poly2
     * @return sum of two polynomials
     */
    public static int[][] addPoly(Poly poly1, Poly poly2) {
        int[][] sum = new int[poly1.noOfTerms + poly2.noOfTerms][2];

        int pointer = 0;
        for (int i = 0; i < Math.max(poly1.noOfTerms, poly2.noOfTerms); i++) {
            if (i < poly1.noOfTerms) {
                sum[pointer][0] = poly1.polynomial[i][0];
                sum[pointer++][1] += poly1.polynomial[i][1];
            }

            if (i < poly2.noOfTerms) {
                sum[pointer][0] = poly2.polynomial[i][0];
                sum[pointer++][1] += poly2.polynomial[i][1];
            }
        }
        return removeDuplicate(sum);

    }

    /**
     * Get the product of the two polynomials
     * 
     * @param poly1
     * @param poly2
     * @return product
     */
    public static int[][] multiplyPoly(Poly poly1, Poly poly2) {
        int[][] product = new int[poly1.noOfTerms * poly2.noOfTerms][2];

        int pointer = 0;
        for (int i = 0; i < poly1.noOfTerms; i++) {
            for (int j = 0; j < poly2.noOfTerms; j++) {
                product[pointer][0] = poly1.polynomial[i][0] + poly2.polynomial[j][0];
                product[pointer++][1] = poly1.polynomial[i][1] * poly2.polynomial[j][1];
            }
        }
        return removeDuplicate(product);
    }
}
