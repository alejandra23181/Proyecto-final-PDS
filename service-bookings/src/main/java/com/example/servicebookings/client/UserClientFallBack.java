package com.example.servicebookings.client;

import com.example.servicebookings.model.User;
import com.example.servicebookings.utils.Response;
import com.example.servicebookings.utils.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserClientFallBack implements UserClient{

    private final ResponseBuilder builder;

    @Override
    public Response findById(Long id) {
        User user = new User();
        return builder.success(user);
    }

    @Override
    public Response findNumberId(Long id) {
        User user = new User();
        return builder.success(user);
    }
}
