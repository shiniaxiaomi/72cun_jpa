package com.lyj.controller;

import com.lyj.dao.FolderDao;
import com.lyj.entity.Folder;
import com.lyj.entity.Result;
import com.lyj.entity.User;
import com.lyj.service.FolderService;
import com.lyj.util.VarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 陆英杰
 * 2018/9/30 11:27
 */

@Controller
@RequestMapping("/folder")
public class FolderController {

    @Autowired
    FolderService folderService;

    @ResponseBody
    @RequestMapping("/query")
    public List<Folder> query(HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Folder> folders = folderService.query(user.getId());

        return folders;

    }

    @ResponseBody
    @RequestMapping("/insertChildren")
    public Result insertChildren(Folder folder,HttpSession session){

        User user = (User) session.getAttribute("user");

        folder.setUser(user);
        folder.setIsHasURL(VarUtil.intFalse);
        folder.setIsLeaf(VarUtil.intTure);

        return folderService.insertChildren(folder);

    }


}
