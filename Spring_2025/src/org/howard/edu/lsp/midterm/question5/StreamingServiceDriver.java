package org.howard.edu.lsp.midterm.question5;

public class StreamingServiceDriver {
    public static void main(String[] args) {
        // Creating instances of different media types
        Streamable music = new Music("Still a Friend - Incognito");
        Streamable movie = new Movie("Avengers: Endgame");
        Streamable audiobook = new Audiobook("A Promised Land – Barack Obama");

        // Testing common behaviors
        System.out.println("Testing common behaviors for all media types:\n");
        music.play();
        music.pause();
        music.stop();
        System.out.println();

        movie.play();
        movie.pause();
        movie.stop();
        System.out.println();

        audiobook.play();
        audiobook.pause();
        audiobook.stop();
        System.out.println();

        // Testing unique behaviors
        Movie movieWithRewind = (Movie) movie;
        movieWithRewind.rewind(30);
        System.out.println();

        Audiobook audiobookWithSpeed = (Audiobook) audiobook;
        audiobookWithSpeed.setPlaybackSpeed(1.5);
        System.out.println();

        Music musicWithPlaylist = (Music) music;
        musicWithPlaylist.addToPlaylist("Favorites");
        System.out.println();
    }
}
