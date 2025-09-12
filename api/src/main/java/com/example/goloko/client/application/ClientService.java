package com.example.goloko.client.application;

import com.example.goloko.client.domain.Client;
import com.example.goloko.client.domain.ClientRepository;
import com.example.goloko.client.web.mapper.ClientMapper;
import com.example.goloko.client.web.request.CreateClientRequest;
import com.example.goloko.client.web.response.ClientResponse;
import com.example.goloko.exceptions.NotFoundException;
import com.example.goloko.subscription_plan.domain.SubscriptionPlan;
import com.example.goloko.subscription_plan.domain.SubscriptionPlanRepository;
import com.example.goloko.user.domain.User;
import com.example.goloko.user.domain.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {
   private final ClientRepository clientRepository;
   private final UserRepository userRepository;
   private final SubscriptionPlanRepository subscriptionPlanRepository;
   private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, UserRepository userRepository,
                         SubscriptionPlanRepository subscriptionPlanRepository, ClientMapper clientMapper)
    {
        this.clientRepository = clientRepository;
        this.userRepository =userRepository;
        this.subscriptionPlanRepository = subscriptionPlanRepository;
        this.clientMapper = clientMapper;
    }
@Transactional
    public Client create(CreateClientRequest request)
    {
        User user = userRepository.findById(request.userId()).orElseThrow(() ->new NotFoundException("User not found"));
        SubscriptionPlan subscriptionPlan = subscriptionPlanRepository.findById(request.subscriptionPlanId())
                .orElseThrow(() -> new NotFoundException("Subscription plan not found"));

        Client client = clientMapper.toEntity(request);
        client.setUser(user);
        client.setSubscriptionPlan(subscriptionPlan);
        return clientRepository.save(client);
    }

    @Transactional(readOnly = true)
    public Optional<ClientResponse> get(Long id){
        return clientRepository.findById(id).map(clientMapper::getClient);
    }
}
