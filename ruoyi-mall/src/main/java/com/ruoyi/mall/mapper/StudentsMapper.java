package com.ruoyi.mall.mapper;

import java.util.List;
import com.ruoyi.mall.domain.Students;

/**
 * 学生列表Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-25
 */
public interface StudentsMapper 
{
    /**
     * 查询学生列表
     * 
     * @param id 学生列表ID
     * @return 学生列表
     */
    public Students selectStudentsById(Long id);

    /**
     * 查询学生列表列表
     * 
     * @param students 学生列表
     * @return 学生列表集合
     */
    public List<Students> selectStudentsList(Students students);

    /**
     * 新增学生列表
     * 
     * @param students 学生列表
     * @return 结果
     */
    public int insertStudents(Students students);

    /**
     * 修改学生列表
     * 
     * @param students 学生列表
     * @return 结果
     */
    public int updateStudents(Students students);

    /**
     * 删除学生列表
     * 
     * @param id 学生列表ID
     * @return 结果
     */
    public int deleteStudentsById(Long id);

    /**
     * 批量删除学生列表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStudentsByIds(String[] ids);
}
