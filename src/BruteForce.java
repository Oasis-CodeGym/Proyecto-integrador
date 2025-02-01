public class BruteForce {
    public static String decryptBruteForce(String text) {
        StringBuilder decryptedText = new StringBuilder( " ");
        new Cipher();
        for (int i = 0; i < Cipher.alphabet.length; i++) {
            decryptedText.append(("Clave #")).append(i).append(":").append( Cipher.desencriptar( text, i) ).append( "\n" );

        }
        return decryptedText.toString();
    }
}
