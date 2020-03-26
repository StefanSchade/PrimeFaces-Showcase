package de.stefanschade.PrimeFacesShowcase;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

@Named
@ApplicationScoped
@NoArgsConstructor
@Getter
@Setter
public class ThemesService {

    private static final Logger logger = Logger.getLogger(ThemesService.class.getName());


    private final String[] themes = {
            "nova-dark",
            "afterdark",
            "afternoon",
            "afterwork",
            "aristo",
            "black-tie",
            "blitzer",
            "bluesky",
            "bootstrap",
            "casablanca",
            "cupertino",
            "cruze",
            "dark-hive",
            "delta",
            "dot-luv",
            "eggplant",
            "excite-bike",
            "flick",
            "glass-x",
            "home",
            "hot-sneaks",
            "humanity",
            "le-frog",
            "midnight",
            "mint-choc",
            "overcast",
            "pepper-grinder",
            "redmond",
            "rocket",
            "sam",
            "smoothness",
            "south-street",
            "start",
            "sunny",
            "swanky-purse",
            "trontastic",
            "ui-darkness",
            "ui-lightness",
            "vader"};
}