package com.lyj.dao;

import com.lyj.entity.Folder;
import com.lyj.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by 陆英杰
 * 2018/9/25 9:42
 */
public interface FolderDao extends JpaRepository<Folder,Integer>{

    //可以通过对象_属性来加入对象中的对象中的属性字段
    @Query("select new Folder(f.id,f.name,f.pId,f.isLeaf,f.isHasURL) from Folder f join f.user user where user.id=:userId")
    public List<Folder> findFoldersByUser_Id(@Param("userId") Integer userId);

}
