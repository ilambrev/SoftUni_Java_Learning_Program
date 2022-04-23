package L06ObjectsAndClasses;

import java.util.Scanner;

public class L04Songs {

    static class Songs {
        String listType;
        String songName;
        String time;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfSongs = Integer.parseInt(scanner.nextLine());

        Songs[] songsList = new Songs[numberOfSongs];

        for (int i = 0; i < numberOfSongs; i++) {
            String[] songString = scanner.nextLine().split("_");
            Songs currentSong = new Songs();
            currentSong.listType = songString[0];
            currentSong.songName = songString[1];
            currentSong.time = songString[2];
            songsList[i] = currentSong;
        }

        String songQuery = scanner.nextLine();

        if (songQuery.equals("all")) {
            for (int i = 0; i < songsList.length; i++) {
                Songs currentSong = songsList[i];
                String songName = currentSong.songName;
                System.out.println(songName);
            }
        } else {
            for (int i = 0; i < songsList.length; i++) {
                Songs currentSong = songsList[i];
                String listType = currentSong.listType;
                String songName = currentSong.songName;
                if (listType.equals(songQuery)) {
                    System.out.println(songName);
                }
            }
        }

    }
}