package com.diplomski.socijalniapi.service;

import com.diplomski.socijalniapi.entity.Post;
import com.diplomski.socijalniapi.entity.RegistrationLink;

import java.util.List;

public interface IRegistrationLinkService {

    List<RegistrationLink> getAllRL();

    void deleteRL(Integer id);

    RegistrationLink getRLById(Integer id);

    RegistrationLink updateRL(Integer id,RegistrationLink rl);

    RegistrationLink createRL(RegistrationLink rl);
}
