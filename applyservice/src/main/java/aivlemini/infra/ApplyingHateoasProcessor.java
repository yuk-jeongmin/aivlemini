package aivlemini.infra;

import aivlemini.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ApplyingHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Applying>> {

    @Override
    public EntityModel<Applying> process(EntityModel<Applying> model) {
        return model;
    }
}
