package com.quarkus.service;

import com.quarkus.model.Policy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@ApplicationScoped
public class PolicyService {

    @Transactional
    public Policy save(Policy policy) {
        Policy.persist(policy);

        return policy;
    }

    @Transactional
    public Policy update(Policy policy) {

        Policy policySaved = Policy.<Policy>findByIdOptional(policy.getId())
                .orElseThrow(() -> new NotFoundException("Policy not found"));

        policySaved.setName(policy.getName());
        policySaved.setType(policy.getType());

        Policy.persist(policySaved);

        return policySaved;
    }

    public List<Policy> findAll() {
        return Policy.listAll();
    }
}
