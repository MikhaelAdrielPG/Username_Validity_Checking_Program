import java.util.InputMismatchException;
import java.util.Scanner;

public class UsernameValidation {
    public void mainProgram() {
        Scanner scanner = new Scanner(System.in);
        String username;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Masukkan nama pengguna: ");
                username = scanner.nextLine();
                isValid = isValidUsername(username);

                if (isValid) {
                    System.out.println("Selamat, nama pengguna valid!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
                scanner.nextLine(); // Membersihkan buffer masukan agar tidak terjadi infinite loop
            }
        }
        scanner.close();
    }

    // Method untuk memvalidasi username
    public  boolean isValidUsername(String username) {
        // Cek panjang username, harus terdiri dari 5 hingga 12 karakter
        if (username.length() < 5 || username.length() > 12) {
            System.out.println("Maaf, nama pengguna harus terdiri dari 5 hingga 12 karakter.");
            return false;
        }

        /*
        * The charAt() method returns the character at the specified index in a string.
        * */

        // Cek apakah karakter pertama adalah huruf
        if (!((username.charAt(0) >= 'a' && username.charAt(0) <= 'z')
                || (username.charAt(0) >= 'A' && username.charAt(0) <= 'Z'))) {
            System.out.println("Maaf, nama pengguna harus dimulai dengan huruf.");
            return false;
        }

        // Cek apakah username hanya mengandung huruf dan angka
        for (int indexUsername = 0; indexUsername < username.length(); indexUsername++) {
            if (!((username.charAt(indexUsername) >= 'a' && username.charAt(indexUsername) <= 'z')
                    || ( username.charAt(indexUsername) >= 'A' && username.charAt(indexUsername) <= 'Z')
                    || ( username.charAt(indexUsername) >= '0' &&  username.charAt(indexUsername) <= '9'))) {
                System.out.println("Maaf, nama pengguna hanya boleh mengandung huruf dan angka.");
                return false;
            }
        }
        // Jika semua kondisi terpenuhi, maka username valid
        return true;
    }
}