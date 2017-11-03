package Clases;

public class Clave {

    private String nombre = "Polybios Estándar";
    private char[] fila = new char[]{'A', 'B', 'C', 'D', 'E'}, columna = new char[]{'A', 'B', 'C', 'D', 'E'};
    private char[][] matriz = new char[][]{{'A', 'B', 'C', 'D', 'E'}, {'F', 'G', 'H', 'I', 'J'}, {'K', 'M', 'N', 'O', 'P'}, {'Q', 'R', 'S', 'T', 'U'}, {'V', 'W', 'X', 'Y', 'Z'}};

    public Clave() {
    }

    public Clave(char[] fila, char[] columna, String nombre) {
        if (fila.length == this.fila.length && columna.length == this.columna.length) {
            this.fila = fila;
            this.columna = columna;
            this.nombre = nombre;
            this.matriz = matriz = new char[][]{{'A', 'B', 'C', 'D', 'E'}, {'F', 'G', 'H', 'I', 'J'}, {'K', 'M', 'N', 'O', 'P'}, {'Q', 'R', 'S', 'T', 'U'}, {'V', 'W', 'X', 'Y', 'Z'}};
            //si la fila length y la columna length es diferente de 5, provocar un error
        }
    }

    public Clave(char[] fila, char[] columna, char[][] matriz, String nombre) {
        if (fila.length == matriz.length && columna.length == matriz[0].length) {
            this.fila = fila;
            this.columna = columna;
            this.matriz = matriz;
            this.nombre = nombre;
            System.out.println("matriz creada");
        } else {
            System.out.println("matriz no creada");
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public char getChar(char k1, char k2, char _nul) {
        for (int i = 0; i < fila.length; i++) {
            for (int j = 0; j < columna.length; j++) {
                if (Character.compare(fila[i], k1) == 0 && Character.compare(columna[j], k2) == 0) {
                    return matriz[i][j];
                }
            }
        }
        return _nul;
    }

    public char getChar(char k1, char k2) {
        for (int i = 0; i < fila.length; i++) {
            for (int j = 0; j < columna.length; j++) {
                if (Character.compare(fila[i], k1) == 0 && Character.compare(columna[j], k2) == 0) {
                    return matriz[i][j];
                }
            }
        }
        return '@';
    }

    public String getClave(char letra, String _nul) {
        for (int i = 0; i < fila.length; i++) {
            for (int j = 0; j < columna.length; j++) {
                if (Character.compare(letra, matriz[i][j]) == 0) {
                    return "" + fila[i] + columna[j];
                }
            }
        }
        return _nul;
    }

    public String getClave(char letra) {
        for (int i = 0; i < fila.length; i++) {
            for (int j = 0; j < columna.length; j++) {
                if (Character.compare(letra, matriz[i][j]) == 0) {
                    return "" + fila[i] + columna[j];
                }
            }
        }
        return "??";
    }

    @Override
    public String toString() {
        return this.nombre; //To change body of generated methods, choose Tools | Templates.
    }

    public static String cifrar(String m, Clave k, String sep) {
        String c = "";
        for (int i = 0; i < m.length(); i++) {
            //System.out.println(m.charAt(i));
            //System.out.println(k.getClave(m.charAt(i)));
            c = c + k.getClave(m.charAt(i)) + sep;
        }
        return c;
    }

    public static String cifrar(String m, Clave k) {
        return cifrar(m, k, " ");
    }

    public static String descifrar(String m, Clave k, String sep) {
        String c = "";
        for (int i = 0; i < m.length(); i = i + 2) {
            //System.out.println(m.charAt(i));
            //System.out.println(k.getClave(m.charAt(i)));
            c = c + k.getChar(m.charAt(i), m.charAt(i + 1)) + sep;
        }
        return c;
    }

    public static String descifrar(String m, Clave k) {
        return descifrar(m, k, " ");
    }

}
