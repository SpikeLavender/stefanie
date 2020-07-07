package com.natsumes.stefanie.service;

import com.github.pagehelper.PageInfo;
import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.entity.form.CommentForm;
import com.natsumes.stefanie.pojo.Comment;

public interface CommentService {

    Response addComment(CommentForm commentForm);

    Response deleteComment(Integer id);

    Response<PageInfo> selectComment(Integer userId, Integer productId, Integer pageNum, Integer pageSize);

    Response updateComment(Comment comment);
}
