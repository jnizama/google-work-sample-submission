package com.google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;
  private boolean isPlaying = false;
  private boolean isPaused = false;
  private String currentVideoId = "";



  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();

  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    System.out.println("Here's a list of all available videos:");
    var videos = this.sortVideo(videoLibrary.getVideos());
    for (var video: videos
         ) {
      System.out.printf("%s (%s) %s%n", video.getTitle(), video.getVideoId(), video.getTags());
    }
  }

  public void playVideo(String videoId) {

    var currentVideo = videoLibrary.getVideo(videoId);
    if(currentVideo == null){
      System.out.printf("Cannot play video: Video does not exist%n");
      return;
    }
    if(isPlaying) {
      System.out.printf("Stopping video: %s%n", currentVideo.getTitle());
    }
      //System.out.printf("Playing video: %s%n", currentVideo.getTitle() );
      //isPaused = false;
      //return;


      isPlaying = true;
      isPaused = false;
      currentVideoId = videoId;
      System.out.printf("Playing video: %s%n", currentVideo.getTitle() );
    //}

  }

  public void stopVideo() {
    if(!isPlaying){
      System.out.println("Cannot stop video: No video is currently playing");
    }
    else
    {
      isPlaying = false;
      var currentVideo = videoLibrary.getVideo(currentVideoId);
      System.out.printf("Stopping video: %s%n", currentVideo.getTitle());
    }

  }

  public void playRandomVideo() {
    if(isPlaying && currentVideoId != ""){
      System.out.printf("Stopping video: %s%n", videoLibrary.getVideo(currentVideoId).getTitle());
    }
    Random generator = new Random();
    var newestVideo = videoLibrary.getVideos().get(generator.nextInt(videoLibrary.getVideos().size()));
    currentVideoId = newestVideo.getVideoId();
    isPlaying = true;
    System.out.printf("Playing video: %s%n", newestVideo.getTitle() );
  }

  public void pauseVideo() {
    if(!isPlaying){
      System.out.printf("Cannot pause video: No video is currently playing");
      return;
    }
    if(isPaused){
      System.out.printf("Video already paused: %s%n", videoLibrary.getVideo(currentVideoId).getTitle());
    }else{
      isPaused = true;
      System.out.printf("Pausing video: %s%n", videoLibrary.getVideo(currentVideoId).getTitle());
    }

  }

  public void continueVideo() {
    if(!isPlaying & !isPaused){
      System.out.printf("Cannot continue video: No video is currently playing");
    }
    if(isPlaying){
      System.out.printf("Cannot continue video: Video is not paused");
    }
    if(isPaused)
      System.out.printf("Continuing video: %s%n",videoLibrary.getVideo(currentVideoId).getTitle());
  }

  public void showPlaying() {
    if(isPlaying && !isPaused){
        System.out.printf("Currently playing: %s (%s) %s%n", videoLibrary.getVideo(currentVideoId).getTitle(), videoLibrary.getVideo(currentVideoId).getVideoId(), videoLibrary.getVideo(currentVideoId).getTags() );
        return;
    }
    if(isPaused){
      System.out.printf("Currently playing: %s (%s) %s - PAUSED%n", videoLibrary.getVideo(currentVideoId).getTitle(), videoLibrary.getVideo(currentVideoId).getVideoId(), videoLibrary.getVideo(currentVideoId).getTags() );
      return;
    }
    System.out.println("No video is currently playing");

  }

  public void createPlaylist(String playlistName) {
    System.out.println("createPlaylist needs implementation");
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {

  }

  public void searchVideosWithTag(String videoTag) {

  }

  public void flagVideo(String videoId) {
    flagVideo(videoId, "Not supplied");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
  public List<Video> sortVideo(List<Video> videos){
    videos.sort(Comparator.comparing(Video::getTitle)
            );
    return videos;
  }

}