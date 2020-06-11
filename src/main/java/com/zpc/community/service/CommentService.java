package com.zpc.community.service;

import com.zpc.community.entity.Comment;
import com.zpc.community.entity.Question;
import com.zpc.community.enums.CommentTypeEnum;
import com.zpc.community.exception.CustomizeErrorCode;
import com.zpc.community.exception.CustomizeException;
import com.zpc.community.mapper.CommentMapper;
import com.zpc.community.mapper.QuestionMapper;
import com.zpc.community.mapper.QuestionMapperExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName: CommentService
 * Package: com.zpc.community.service
 * Description:
 *
 * @Date: 2020/6/1 11:21
 * @Author:zpc@qq.com
 */
@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionMapperExt questionMapperExt;
    @Transactional
    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        if (comment.getType() == null || !CommentTypeEnum.isExit(comment.getType())) {
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }
        if (comment.getType() == CommentTypeEnum.COMMENT.getType()) {
            //回复评论
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (dbComment == null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
            commentMapper.insert(comment);
        } else {
            //回复问题
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            if (question == null) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            commentMapper.insert(comment);
            question.setCommentCount(1);
            questionMapperExt.incCommentCount(question);
        }
    }
}
