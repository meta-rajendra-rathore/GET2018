/**
 * This class is used to design polynomial representation
 * @author Rajendra Singh Rathore
 *
 */

package adt_cdt;

public final class Poly {

    final int[] polynomial;
    final int noOfTerms;

    /**
     * Public constructor
     * @param powers
     */
    public Poly(int[] powers) {
        noOfTerms = powers.length;
        polynomial = new int[noOfTerms];

        for (int i = 0; i < noOfTerms; i++) {
            polynomial[i] = powers[i];
        }
    }

    /**
     * Evaluate the value of the polynomial
     * @param valueOfVariable
     * @return totalValue
     */
    public float evaluate(float valueOfVariable) {
        float totalValue = 0.0F;

        for (int i = 0; i < noOfTerms; i++) {
            totalValue += ((float) (Math.pow(valueOfVariable, i)) * polynomial[i]);
        }
        return totalValue;
    }

    /**
     * Get the degree of the polynomial
     * @return degree
     */
    public int degree() {
        return noOfTerms;
    }

    /**
     * Add the two given polynomials
     * @param poly1
     * @param poly2
     * @return sum of two polynomials
     */
    public int[] addPoly(Poly poly1, Poly poly2) {
        int[] sum = new int[Math.max(poly1.noOfTerms, poly2.noOfTerms)];

        for (int i = 0; i < sum.length; i++) {
            if (i < poly1.noOfTerms && i < poly2.noOfTerms) {
                sum[i] = poly1.polynomial[i] + poly2.polynomial[i];
            } else {
                if (poly1.noOfTerms < poly2.noOfTerms) {
                    sum[i] = poly2.polynomial[i];
                } else {
                    sum[i] = poly1.polynomial[i];
                }
            }
        }
        return sum;
    }

    /**
     * Get the product of the two polynomials
     * @param poly1
     * @param poly2
     * @return product
     */
    public int[] multiplyP(Poly poly1, Poly poly2) {
        int[] product = new int[poly1.noOfTerms + poly2.noOfTerms -1];

        for (int i = 0; i < poly1.noOfTerms; i++) {
            for (int j = 0; j < poly2.noOfTerms; j++) {
                product[i + j] += poly1.polynomial[i] * poly2.polynomial[j];
            }
        }
        return product;
    }
}
