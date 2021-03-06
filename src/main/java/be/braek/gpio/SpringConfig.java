package be.braek.gpio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan("be.braek.gpio")
@PropertySource(value = "classpath:config.properties")
public class SpringConfig implements WebMvcConfigurer {

    @Value("${pins}")
    private int[] pins;

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public GpioController gpio() {
        return GpioFactory.getInstance();
    }

    @Bean
    public Gson gson() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Pin.class, new PinAdapter());
        return builder.create();
    }

    @Bean
    @Autowired
    public List<Pin> pins(GpioController gpio) {
        List<Pin> resources = new ArrayList<Pin>();
        for(int i = 0; i < pins.length; i++) {
            resources.add(new Pin(gpio, i + 1, pins[i]));
        }
        return resources;
    }
}
