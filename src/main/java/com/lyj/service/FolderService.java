package com.lyj.service;

import com.lyj.dao.FolderDao;
import com.lyj.entity.Folder;
import com.lyj.entity.Result;
import com.lyj.entity.User;
import com.lyj.util.ResultUtil;
import com.lyj.util.VarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

/**
 * Created by 陆英杰
 * 2018/10/1 22:35
 */

@Service
public class FolderService {

    @Autowired
    FolderDao folderDao;

    public List<Folder> query(Integer userId){

        return folderDao.findFoldersByUser_Id(userId);
    }

    @Transactional
    public Result insertChildren(Folder folder) {
        Folder save = folderDao.save(folder);
        if(save!=null){

            Optional<Folder> folder1 = folderDao.findById(folder.getpId());
            if(folder1.get().getIsLeaf()==VarUtil.intFalse){//如果已经不是叶子节点,那么就不再标记为叶子节点
                folder1.get().setIsLeaf(VarUtil.intFalse);
                folderDao.save(folder1.get());
            }

            return ResultUtil.success("保存成功!");
        }
        return ResultUtil.error("保存失败!");
    }
}
