# Project 1 Jukebox:
A simple Java program that plays music from a pre composed list of songs.

===========================================================================

# Controls Package:
Handles game controller support through the use of a keyboard to
simulate an old fashioned NES controller.

# Main Package:
The basic game engine code that starts the game and switches to
the next game screen. It also builds the game window for the
player to view the initial Titlescreen.

# Screens Package:
Holds the various game screens that the game engine will switch
between. Game screens are composed of words, images, pointers,
and audio components. The Titlescreen is the simplest screen
to be displayed having only a Start and Quit option below the
title. The Jukebox is more complex as it has Playtrack,
Playsong, Prevsong, NextSong and Quit options.

# Sprites Package:
Keeps track of all the different sprites that are needed for the
different game screens. Pointers are important in keeping track
of which option is being selected at any given time. MusicalNotes
are simple sprites that give a bit of flair to the Jukebox
section. The RecordPlayer sprite is used to represent the
different musical tracks that get played at any given time. The
DiskJockey is a simple character sprite that manages the Jukebox
screen.

===========================================================================

# Songlist:
Contains a simple text file that pulls in others songs needed
for the Jukebox to function.

# Songs:
Holds the different audio files that make up the Jukebox.

# Sprites:
Contains the different spritesheets that the Jukebox needs.

===========================================================================

# Lib:
Contains the various jar files needed to read the song data.
