package videos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VideoPlatform {

    private List<Channel> channels = new ArrayList<>();

    public List<Channel> getChannels() {
        return channels;
    }

    public void readDataFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                parseLine(line);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot open file for read!", ioe);
        }
    }

    public int calculateSumOfVideos() {
        return channels.stream()
                .mapToInt(Channel::getNumberOfVideos)
                .sum();
    }

    private void parseLine(String line) {
        String[] parts = line.split(";");
        String channelName = parts[0];
        int subscriptions = Integer.parseInt(parts[1]);
        int numberOfVideos = Integer.parseInt(parts[2]);
        Channel channel = new Channel(channelName, subscriptions, numberOfVideos);
        channels.add(channel);
    }
}
