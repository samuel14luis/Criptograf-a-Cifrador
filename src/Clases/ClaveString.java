package Clases;

import java.io.Serializable;
import javax.swing.table.DefaultTableModel;

public class ClaveString implements Serializable {

    private String nombre = "Polybios Estándar";
    private String[] fila = new String[]{"A0", "B0", "C0", "D0", "E0"},
            columna = new String[]{"A1", "B1", "C1", "D1", "E1"};
    private String[][] matriz = new String[][]{{"A", "B", "C", "D", "E"}, {"F", "G", "H", "I", "J"}, {"K", "M", "N", "O", "P"}, {"Q", "R", "S", "T", "U"}, {"V", "W", "X", "Y", "Z"}};
    private String _nullClave = "??";
    private String _nullMatriz = "?";
    private boolean editable = true;

    //constructores
    /**
     * Constructor por defecto, matriz 5*5 con claves A, B, C, D, E
     */
    public ClaveString() {
        System.out.println("clave creada");
    }

    /**
     *
     * @param fila vector con las claves que se tomaran para la fila
     * @param columna vector las claves que se tomaran para la columna
     * @param nombre el nombre del sistema de cifrado (ejemplo: cifrado
     * Polybius)
     */
    public ClaveString(String[] fila, String[] columna, String nombre) {
        if (esClaveValida(fila, columna, matriz, _nullClave, _nullMatriz)) {
            this.fila = fila;
            this.columna = columna;
            this.nombre = nombre;
            System.out.println("clave creada");
        } else {
            System.out.println("clave no creada");
        }
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean modificable) {
        this.editable = modificable;
    }

    /**
     *
     * @param fila vector con las claves que se tomaran para la fila
     * @param columna vector las claves que se tomaran para la columna
     * @param matriz matriz con las claves que se tomaran para la tabla central
     * @param nombre el nombre del sistema de cifrado (ejemplo: cifrado
     * Polybius)
     * @param _nullClave clave del mismo tipo que los elementos de fila y
     * columna
     * @param _nullMatriz clave del mismo tipo que los elementos de la matriz
     */
    public ClaveString(String[] fila, String[] columna, String[][] matriz, String nombre, String _nullClave, String _nullMatriz) {
        if (esClaveValida(fila, columna, matriz, _nullClave, _nullMatriz)) {
            this.fila = fila;
            this.columna = columna;
            this.matriz = matriz;
            this.nombre = nombre;
            this._nullClave = _nullClave;
            this._nullMatriz = _nullMatriz;
            System.out.println("clave creada");
        } else {
            System.out.println("clave no creada");
        }
    }

    //métodos getters
    /**
     *
     * @return el nombre del sistema de cifrado (ejemplo: cifrado Polybius)
     */
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return el nombre del sistema de cifrado (ejemplo: cifrado Polybius)
     */
    @Override
    public String toString() {
        return this.nombre; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return el largo de las claves
     */
    public int getLength() {
        return fila[0].length();
    }

    /**
     *
     * @param k1 la clave que se buscara en la fila
     * @param k2 la clave que se buscara en la columna
     * @param _nul valor auxiliar por si no se encuentra la cadena que concuerde
     * con las claves dadas
     * @return cadena que concuerda con las claves dadas
     */
    public String getChar(String k1, String k2, String _nul) {
        for (int i = 0; i < fila.length; i++) {
            for (int j = 0; j < columna.length; j++) {
                if (fila[i].equals(k1) && columna[j].equals(k2)) {
                    return matriz[i][j];
                }
            }
        }
        return _nul;
    }

    public String getChar(String k1, String k2) {
        return getChar(k1, k2, _nullMatriz);
    }

    public String getClave(String letra, String _nul) {
        for (int i = 0; i < fila.length; i++) {
            for (int j = 0; j < columna.length; j++) {
                if (letra.equals(matriz[i][j])) {
                    return "" + fila[i] + columna[j];
                }
            }
        }
        return _nul;
    }

    public String getClave(String letra) {
        return getClave(letra, _nullClave + _nullClave);
    }

    /**
     *
     * @param m es el mensaje a cifrar
     * @param k es la clave que se va usar para cifrar m
     * @param sep es el String que va separar cada bloque cifrado
     * @return el criptograma (m ya cifrado)
     */
    public static String cifrar(String m, ClaveString k, String sep) {
        String c = "";
        for (int i = 0; i < m.length(); i++) {
            //System.out.println(m.charAt(i));
            //System.out.println(k.getClave(m.charAt(i)));
            c = c + k.getClave(m.substring(i, i + 1)) + (i < m.length() - 1 ? sep : "");
        }
        return c;
    }

    public static String cifrar(String m, ClaveString k, String sep, String sep_de_Descifrado) {
        return cifrar(m.replaceAll(sep_de_Descifrado, ""), k, sep);
    }

    /**
     *
     * @param m es el mensaje a cifrar
     * @param k es la clave que se va usar para cifrar m
     * @return el criptograma (m ya cifrado)
     */
    public static String cifrar(String m, ClaveString k) {
        return cifrar(m, k, "");
    }

    public static String descifrar(String m, ClaveString k, String sep) {
        String c = "";
        //System.out.println("descifrando...");
        //System.out.println("m: "+m+"  length:"+m.length());
        for (int i = 0; i < m.length(); i = i + k.getLength() * 2) {
            //System.out.println("i: "+i+"  i+k+1: "+(i+k.getLength())+"  -  i+k: "+(i+k.getLength())+"  i+k*2+1: "+(i+k.getLength()*2));
            //System.out.println(m.substring(i, i+k.getLength())+ m.substring(i + k.getLength(), i+k.getLength()*2));
            //System.out.println(k.getChar(m.substring(i, i+k.getLength()), m.substring(i + k.getLength(), i+k.getLength()*2)));
            //System.out.println(i+" - "+m.length()+"  : "+k.getLength()*2);
            c = c + k.getChar(m.substring(i, i + k.getLength()), m.substring(i + k.getLength(), i + k.getLength() * 2)) + (i < m.length() - k.getLength() * 2 ? sep : "");
        }
        return c;
    }

    public static String descifrar(String m, ClaveString k, String sep, String sep_de_Cifrado) {
        return descifrar(m.replaceAll(sep_de_Cifrado, ""), k, sep);
    }

    public static String descifrar(String m, ClaveString k) {
        return descifrar(m, k, "");
    }

    //métodos nuevos
    /**
     * verifica que el vector enviado no tenga elementos repetidos y sus
     * elementos sean del mismo length
     *
     * @param vector vector a analizar
     * @param nombre nombre del vector (opcional)
     * @param _null String que se pondra en caso no se encuentre la cadena de
     * cifrado, debe ser diferente a cualquier valor dentro del vector
     * @return true si cumple con los requisitos antes mencionados y false si no
     * cumple
     */
    public static boolean verificarVector(String[] vector, String nombre, String _null) {
        System.out.println("  - verificando " + nombre + "...");
        boolean _valido = true;
        for (int i = 0; i < vector.length; i++) {
            for (int j = i + 1; j < vector.length; j++) {
                String ci, cj;
                ci = vector[i];
                cj = vector[j];
                //System.out.println(ci + "  " + cj);
                if (ci.equals(cj) || ci.length() != cj.length()) {
                    _valido = false;
                    System.out.println("    No es válido por:\n    o " + ci + " y " + cj + " son iguales?\n    o " + ci + " y " + cj + " son de largo distinto?");
                    break;
                }
                if (ci.equals(_null) || cj.equals(_null) || ci.length() != _null.length()) {
                    _valido = false;
                    System.out.println("    el null " + _null + " no tiene la misma longitud o coindide con alguno de estos: " + ci + " - " + cj);
                    break;
                }
            }
            if (!_valido) {
                break;
            }
        }
        //los elementos del vector son diferentes entre si
        //los elementos del vector tienen el mismo largo
        return _valido;
    }

    /**
     * verifica que el vector enviado no tenga elementos repetidos y sus
     * elementos sean del mismo length
     *
     * @param vector vector a analizar
     * @param _null String que se pondra en caso no se encuentre la cadena de
     * cifrado, debe ser diferente a cualquier valor dentro del vector
     * @return true si cumple con los requisitos antes mencionados y false si no
     * cumple
     */
    public static boolean verificarVector(String[] vector, String _null) {
        return verificarVector(vector, "vector", _null);
    }

    /**
     * se encarga de verificar si
     *
     * @param fila
     * @param columna
     * @param matriz cumplen con los requisitos para servir como clave base
     * @param _nullClave String que se pondra en caso no se encuentre la cadena
     * de cifrado
     * @param _nullMatriz
     * @return true si se puede usar como clave base y false si no.
     */
    public static boolean esClaveValida(String[] fila, String[] columna, String[][] matriz, String _nullClave, String _nullMatriz) {
        //fila y columna tienen el mismo largo
        boolean _valido;

        //comprueba la valides de los vectores clave
        _valido = fila[0].length() == columna[0].length() && verificarVector(fila, "vector fila", _nullClave) && verificarVector(columna, "vector columna", _nullClave);

        System.out.print(_valido ? "_vectores aceptados, " : "_vectores no aceptados, ");

        //comprueba la valides de la matriz a partir de la valides de los vectores clave
        if (_valido && matriz.length == fila.length && matriz[0].length == columna.length) {
            System.out.println("comprobando matriz...");
            String[] m = new String[matriz.length * matriz[0].length];
            for (int i = 0; i < matriz.length * matriz[0].length; i = i + matriz[0].length) {
                for (int j = 0; j < matriz[0].length; j++) {
                    m[i + j] = matriz[i / matriz[0].length][j];
                    //System.out.println("k: "+(i+j)+"  i: "+i+" j: "+j+" - "+matriz[i/matriz[0].length][j]);
                }
            }
            _valido = _valido && verificarVector(m, "matriz", _nullMatriz);
        } else {
            _valido = false;
            System.out.println(_valido ? "\n_la dimension de la matriz no encaja con las de las claves fila y columna" : "");
        }
        System.out.println("Clave " + (_valido ? "aceptada" : "rechazada"));
        return _valido;
    }

    public DefaultTableModel getTableModel(boolean editable) {
        String[] columnas = new String[matriz[0].length + 1];
        for (int i = 0; i < columnas.length; i++) {
            //columnas[i] = "columna "+(i+1);
            columnas[i] = " ";
        }
        String[][] datos = new String[fila.length + 1][columna.length + 1];
        for (int i = 0; i < fila.length + 1; i++) {
            for (int j = 0; j < columna.length + 1; j++) {
                if (i == j && i == 0) {
                    datos[i][j] = "";
                } else if (i == 0) {
                    datos[i][j] = columna[j - 1];
                } else if (j == 0) {
                    datos[i][j] = fila[i - 1];
                } else {
                    datos[i][j] = matriz[i - 1][j - 1];
                }
            }
        }
        DefaultTableModel modelo;
        if (editable) {
            modelo = new DefaultTableModel(
                    datos,
                    columnas
            );
        } else {
            modelo = new DefaultTableModel(
                    datos,
                    columnas
            ) {                
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            };
        }

        return modelo;
    }
}
