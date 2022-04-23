package L06ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L04SongsV3 {

    public static class Song {
        private String listType;
        private String songName;
        private String time;

        Song(String type, String name, String time) {
            this.listType = type;
            this.songName = name;
            this.time = time;
        }

        public String getListType() {

            return listType;
        }

        public void setListType(String listType) {

            this.listType = listType;
        }

        public String getSongName() {

            return songName;
        }

        public void setSongName(String songName) {

            this.songName = songName;
        }

        public String getTime() {

            return time;
        }

        public void setTime(String time) {

            this.time = time;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfSongs = Integer.parseInt(scanner.nextLine());

        List<Song> songsList = new ArrayList<>();

        for (int i = 0; i < numberOfSongs; i++) {
            String[] songString = scanner.nextLine().split("_");
            String listType = songString[0];
            String songName = songString[1];
            String time = songString[2];

            Song song = new Song(listType, songName, time);

            songsList.add(song);
        }

        String songQuery = scanner.nextLine();

        if (songQuery.equals("all")) {
            for (Song song : songsList) {
                System.out.println(song.getSongName());
            }
        } else {
            for (Song song : songsList) {
                if (song.getListType().equals(songQuery)) {
                    System.out.println(song.getSongName());
                }
            }
        }
    }
}