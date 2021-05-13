package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/web.properties")
@Config.LoadPolicy(Config.LoadType.MERGE)
public interface WebConfig extends Config{

    @Config.Key("web.url")
    String webUrl();
}