package com.diplomski.socijalniapi.service;

import com.diplomski.socijalniapi.entity.Post;
import com.diplomski.socijalniapi.entity.RegistrationLink;
import com.diplomski.socijalniapi.entity.User;
import com.diplomski.socijalniapi.repository.PostRepository;
import com.diplomski.socijalniapi.repository.RegistrationLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationLinkService implements IRegistrationLinkService{

    @Autowired
    protected RegistrationLinkRepository rlr;

    @Override
    public List<RegistrationLink> getAllRL() {
        return rlr.findAll();
    }

    @Override
    public void deleteRL(Integer id) {
        RegistrationLink rl=rlr.findById(id).orElseThrow(() -> new RuntimeException("Greska")); //FIXME Napraviti izuzetak
        rlr.delete(rl);
    }

    @Override
    public RegistrationLink getRLById(Integer id) {
        return rlr.findById(id).orElseThrow(() -> new RuntimeException("Greska"));
    }

    @Override
    public RegistrationLink updateRL(Integer id, RegistrationLink rl) {
        RegistrationLink reglink=rlr.findById(id).orElseThrow(() -> new RuntimeException("Korisnik ne postoji")); //FIXME Napraviti izuzetak
        reglink.setUrl(rl.getUrl());
        reglink.setDatum_pravljenja(rl.getDatum_pravljenja());
        reglink.setValidan(rl.isValidan());
        return rlr.save(reglink);
    }

    @Override
    public RegistrationLink createRL(RegistrationLink rl) {
        return rlr.save(rl);
    }
}
