package com.diplomski.socijalniapi.service;

import com.diplomski.socijalniapi.entity.CodeGroup;

import java.util.List;

public interface ICodeGroupService {

    List<CodeGroup> getAllCodeGroups();

    void deleteCodeGroup(Integer id);

    CodeGroup getCodeGroupById(Integer id);

    CodeGroup updateCodeGroup(Integer id,CodeGroup group);

    CodeGroup createCodeGroup(CodeGroup group);
}
