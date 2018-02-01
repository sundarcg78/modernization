package org.superbiz.moviefun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.superbiz.moviefun.albumsapi.AlbumsClient;
import org.superbiz.moviefun.moviesapi.MoviesClient;

@Configuration
public class ClientConfiguration {

    @Value("${albums.url}") String albumsUrl;
    @Value("${movies.url}") String moviesUrl;

    Logger logger = LoggerFactory.getLogger(getClass());
    @Bean
    public AlbumsClient albumsClient(RestOperations restOperations) {
        return new AlbumsClient(albumsUrl, restOperations);
    }

    @Bean
    public MoviesClient moviesClient(RestOperations restOperations) {
        logger.debug("restOperations : {} ", restOperations);
        return new MoviesClient(moviesUrl, restOperations);
    }
}
