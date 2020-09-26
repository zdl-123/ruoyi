package com.ruoyi.mall.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mall.mapper.StudentsMapper;
import com.ruoyi.mall.domain.Students;
import com.ruoyi.mall.service.IStudentsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 学生列表Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-25
 */
@Service
public class StudentsServiceImpl implements IStudentsService 
{
    @Autowired
    private StudentsMapper studentsMapper;

    /**
     * 查询学生列表
     * 
     * @param id 学生列表ID
     * @return 学生列表
     */
    @Override
    public Students selectStudentsById(Long id)
    {
        return studentsMapper.selectStudentsById(id);
    }

    /**
     * 查询学生列表列表
     * 
     * @param students 学生列表
     * @return 学生列表
     */
    @Override
    public List<Students> selectStudentsList(Students students)
    {
        return studentsMapper.selectStudentsList(students);
    }

    /**
     * 新增学生列表
     * 
     * @param students 学生列表
     * @return 结果
     */
    @Override
    public int insertStudents(Students students)
    {
        return studentsMapper.insertStudents(students);
    }

    /**
     * 修改学生列表
     * 
     * @param students 学生列表
     * @return 结果
     */
    @Override
    public int updateStudents(Students students)
    {
        return studentsMapper.updateStudents(students);
    }

    /**
     * 删除学生列表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteStudentsByIds(String ids)
    {
        return studentsMapper.deleteStudentsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生列表信息
     * 
     * @param id 学生列表ID
     * @return 结果
     */
    @Override
    public int deleteStudentsById(Long id)
    {
        return studentsMapper.deleteStudentsById(id);
    }
}
