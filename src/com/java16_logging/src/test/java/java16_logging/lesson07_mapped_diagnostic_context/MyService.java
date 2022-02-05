package java16_logging.lesson07_mapped_diagnostic_context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyService {

    private static final Logger log = LoggerFactory.getLogger(MyService.class);

    private MyRepository repository;

    public MyService(MyRepository repository) {
        this.repository = repository;
    }

    public void save(String requestId) {
        log.info("Service Save");
        this.repository.save(requestId);
    }
}
