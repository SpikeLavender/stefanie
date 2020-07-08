package com.natsumes.stefanie.service.impl;

import com.natsumes.stefanie.mapper.CommentMapper;
import com.natsumes.stefanie.pojo.Comment;
import com.natsumes.stefanie.service.DubboCommentService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class DubboCommentServiceImpl implements DubboCommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Comment comment) {
        return commentMapper.insert(comment);
    }

    @Override
    public int insertSelective(Comment comment) {
        return commentMapper.insertSelective(comment);
    }

    @Override
    public Comment selectByPrimaryKey(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Comment comment) {
        return commentMapper.updateByPrimaryKeySelective(comment);
    }

    @Override
    public int updateByPrimaryKey(Comment comment) {
        return commentMapper.updateByPrimaryKey(comment);
    }

    @Override
    public List<Comment> selectSelective(Comment comment) {
        return commentMapper.selectSelective(comment);
    }
}
