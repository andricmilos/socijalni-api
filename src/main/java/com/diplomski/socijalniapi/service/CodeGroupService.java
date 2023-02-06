package com.diplomski.socijalniapi.service;

import com.diplomski.socijalniapi.entity.CodeGroup;
import com.diplomski.socijalniapi.repository.CodeGrupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeGroupService implements ICodeGroupService {

    @Autowired
    protected CodeGrupRepository gr;

    @Override
    public List<CodeGroup> getAllCodeGroups() {
        return gr.findAll();
    }

    @Override
    public void deleteCodeGroup(Integer id) {
        CodeGroup group=gr.findById(id).orElseThrow(() -> new RuntimeException("Greska"));
        gr.delete(group);
    }

    @Override
    public CodeGroup getCodeGroupById(Integer id) {
        return gr.findById(id).orElseThrow(() -> new RuntimeException("Greska"));
    }

    @Override
    public CodeGroup updateCodeGroup(Integer id, CodeGroup group) {
        CodeGroup staragrupa=gr.findById(id).orElseThrow(() -> new RuntimeException("Greska"));
        staragrupa.setIme(group.getIme());
        staragrupa.setOpis(group.getOpis());
        return gr.save(staragrupa);
    }

    @Override
    public CodeGroup createCodeGroup(CodeGroup group) {
        return gr.save(group);
    }

}
