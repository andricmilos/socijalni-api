package com.diplomski.socijalniapi.service;

import com.diplomski.socijalniapi.entity.RegistrationLink;
import com.diplomski.socijalniapi.entity.ResetPswdLink;

import java.util.List;

public interface IResetPswdLinkService {
    List<ResetPswdLink> getAllRPL();

    void deleteRPL(Integer id);

    ResetPswdLink getRPLById(Integer id);

    ResetPswdLink updateRPL(Integer id,ResetPswdLink rpl);

    ResetPswdLink createRPL(ResetPswdLink rpl);
}
