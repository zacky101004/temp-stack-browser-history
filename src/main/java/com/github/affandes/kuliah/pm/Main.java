package com.github.affandes.kuliah.pm;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    final LinkedList<String> history;

    public Main() {
        history = new LinkedList<>();
    }

    public void view() {
        if (history.isEmpty()) {
            System.out.println("HISTORY INI KOSONG.");
        } else {
            System.out.println("Browser History (BARU KE LAMAt):");
            for (int i = history.size() - 1; i >= 0; i--) {
                System.out.println(history.get(i));
            }
        }
    }

    public void browse(String url) {
        history.add(url);
        System.out.println("KUNJUNGI: " + url);
    }


    public void back() {
        if (history.isEmpty()) {
            System.out.println("Tidak ada situs web sebelumnya untuk dikunjungi lagi");
        } else {
            String lastVisited = history.removeLast();
            System.out.println("balik ke: " + lastVisited);
        }
    }

    public static void main(String[] args) {
        Main browser = new Main();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("SIMULASI BROWSER HISTORY");
        System.out.println("perintah yang tersedia: browse <url>, view, back, exit");

        while (true) {
            System.out.print("\nEnter command: ");
            command = scanner.nextLine().trim();

            if (command.startsWith("browse")) {
                String[] parts = command.split(" ", 2);
                if (parts.length == 2) {
                    browser.browse(parts[1]);
                } else {
                    System.out.println("Berikan URL.");
                }
            } else if (command.equals("view")) {
                browser.view();
            } else if (command.equals("back")) {
                browser.back();
            } else if (command.equals("exit")) {
                System.out.println("Keluar browser...");
                break;
            } else {
                System.out.println("command tidak tersedia tolong coba lagi.");
            }
        }

        scanner.close();
    }
}
