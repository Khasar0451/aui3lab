import com.example.dwarf.repository.DwarfRepo;
import com.example.dwarf.service.DwarfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
public class Config {
    @Autowired
    private DwarfRepo repo; // Replace YourRepository with the actual repository class

    @Bean
    public DwarfService dwarfService() {
        return new DwarfService(repo);
    }
}
