package com.diplomski.socijalniapi.service;

import com.diplomski.socijalniapi.entity.RegistrationLink;
import com.diplomski.socijalniapi.entity.ResetPswdLink;
import com.diplomski.socijalniapi.repository.RegistrationLinkRepository;
import com.diplomski.socijalniapi.repository.ResetPswdLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ResetPswdLinkService implements IResetPswdLinkService{

    @Autowired
    protected ResetPswdLinkRepository rpl;

    @Override
    public List<ResetPswdLink> getAllRPL() {
        return rpl.findAll();
    }

    @Override
    public void deleteRPL(Integer id) {
        ResetPswdLink rl=rpl.findById(id).orElseThrow(() -> new RuntimeException("Greska")); //FIXME Napraviti izuzetak
        rpl.delete(rl);
    }

    @Override
    public ResetPswdLink getRPLById(Integer id) {
        return rpl.findById(id).orElseThrow(() -> new RuntimeException("Greska"));
    }

    @Override
    public ResetPswdLink updateRPL(Integer id, ResetPswdLink rl) {
        ResetPswdLink reslink=rpl.findById(id).orElseThrow(() -> new RuntimeException("Korisnik ne postoji")); //FIXME Napraviti izuzetak
        reslink.setUrl(rl.getUrl());
        reslink.setDatum_pravljenja(rl.getDatum_pravljenja());
        reslink.setValidan(rl.isValidan());
        return rpl.save(reslink);
    }

    @Override
    public ResetPswdLink createRPL(ResetPswdLink rl) {
        return rpl.save(rl);
    }
}
