package com.djb.aixiao.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbWorkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbWorkExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andWorkIdIsNull() {
            addCriterion("work_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkIdIsNotNull() {
            addCriterion("work_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkIdEqualTo(String value) {
            addCriterion("work_id =", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotEqualTo(String value) {
            addCriterion("work_id <>", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdGreaterThan(String value) {
            addCriterion("work_id >", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdGreaterThanOrEqualTo(String value) {
            addCriterion("work_id >=", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdLessThan(String value) {
            addCriterion("work_id <", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdLessThanOrEqualTo(String value) {
            addCriterion("work_id <=", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdLike(String value) {
            addCriterion("work_id like", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotLike(String value) {
            addCriterion("work_id not like", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdIn(List<String> values) {
            addCriterion("work_id in", values, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotIn(List<String> values) {
            addCriterion("work_id not in", values, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdBetween(String value1, String value2) {
            addCriterion("work_id between", value1, value2, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotBetween(String value1, String value2) {
            addCriterion("work_id not between", value1, value2, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkNameIsNull() {
            addCriterion("work_name is null");
            return (Criteria) this;
        }

        public Criteria andWorkNameIsNotNull() {
            addCriterion("work_name is not null");
            return (Criteria) this;
        }

        public Criteria andWorkNameEqualTo(String value) {
            addCriterion("work_name =", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameNotEqualTo(String value) {
            addCriterion("work_name <>", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameGreaterThan(String value) {
            addCriterion("work_name >", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameGreaterThanOrEqualTo(String value) {
            addCriterion("work_name >=", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameLessThan(String value) {
            addCriterion("work_name <", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameLessThanOrEqualTo(String value) {
            addCriterion("work_name <=", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameLike(String value) {
            addCriterion("work_name like", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameNotLike(String value) {
            addCriterion("work_name not like", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameIn(List<String> values) {
            addCriterion("work_name in", values, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameNotIn(List<String> values) {
            addCriterion("work_name not in", values, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameBetween(String value1, String value2) {
            addCriterion("work_name between", value1, value2, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameNotBetween(String value1, String value2) {
            addCriterion("work_name not between", value1, value2, "workName");
            return (Criteria) this;
        }

        public Criteria andCollectTypeIsNull() {
            addCriterion("collect_type is null");
            return (Criteria) this;
        }

        public Criteria andCollectTypeIsNotNull() {
            addCriterion("collect_type is not null");
            return (Criteria) this;
        }

        public Criteria andCollectTypeEqualTo(Integer value) {
            addCriterion("collect_type =", value, "collectType");
            return (Criteria) this;
        }

        public Criteria andCollectTypeNotEqualTo(Integer value) {
            addCriterion("collect_type <>", value, "collectType");
            return (Criteria) this;
        }

        public Criteria andCollectTypeGreaterThan(Integer value) {
            addCriterion("collect_type >", value, "collectType");
            return (Criteria) this;
        }

        public Criteria andCollectTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_type >=", value, "collectType");
            return (Criteria) this;
        }

        public Criteria andCollectTypeLessThan(Integer value) {
            addCriterion("collect_type <", value, "collectType");
            return (Criteria) this;
        }

        public Criteria andCollectTypeLessThanOrEqualTo(Integer value) {
            addCriterion("collect_type <=", value, "collectType");
            return (Criteria) this;
        }

        public Criteria andCollectTypeIn(List<Integer> values) {
            addCriterion("collect_type in", values, "collectType");
            return (Criteria) this;
        }

        public Criteria andCollectTypeNotIn(List<Integer> values) {
            addCriterion("collect_type not in", values, "collectType");
            return (Criteria) this;
        }

        public Criteria andCollectTypeBetween(Integer value1, Integer value2) {
            addCriterion("collect_type between", value1, value2, "collectType");
            return (Criteria) this;
        }

        public Criteria andCollectTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_type not between", value1, value2, "collectType");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIsNull() {
            addCriterion("close_time is null");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIsNotNull() {
            addCriterion("close_time is not null");
            return (Criteria) this;
        }

        public Criteria andCloseTimeEqualTo(Date value) {
            addCriterion("close_time =", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotEqualTo(Date value) {
            addCriterion("close_time <>", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeGreaterThan(Date value) {
            addCriterion("close_time >", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("close_time >=", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeLessThan(Date value) {
            addCriterion("close_time <", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeLessThanOrEqualTo(Date value) {
            addCriterion("close_time <=", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIn(List<Date> values) {
            addCriterion("close_time in", values, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotIn(List<Date> values) {
            addCriterion("close_time not in", values, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeBetween(Date value1, Date value2) {
            addCriterion("close_time between", value1, value2, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotBetween(Date value1, Date value2) {
            addCriterion("close_time not between", value1, value2, "closeTime");
            return (Criteria) this;
        }

        public Criteria andClassesIdIsNull() {
            addCriterion("classes_id is null");
            return (Criteria) this;
        }

        public Criteria andClassesIdIsNotNull() {
            addCriterion("classes_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassesIdEqualTo(Long value) {
            addCriterion("classes_id =", value, "classesId");
            return (Criteria) this;
        }

        public Criteria andClassesIdNotEqualTo(Long value) {
            addCriterion("classes_id <>", value, "classesId");
            return (Criteria) this;
        }

        public Criteria andClassesIdGreaterThan(Long value) {
            addCriterion("classes_id >", value, "classesId");
            return (Criteria) this;
        }

        public Criteria andClassesIdGreaterThanOrEqualTo(Long value) {
            addCriterion("classes_id >=", value, "classesId");
            return (Criteria) this;
        }

        public Criteria andClassesIdLessThan(Long value) {
            addCriterion("classes_id <", value, "classesId");
            return (Criteria) this;
        }

        public Criteria andClassesIdLessThanOrEqualTo(Long value) {
            addCriterion("classes_id <=", value, "classesId");
            return (Criteria) this;
        }

        public Criteria andClassesIdIn(List<Long> values) {
            addCriterion("classes_id in", values, "classesId");
            return (Criteria) this;
        }

        public Criteria andClassesIdNotIn(List<Long> values) {
            addCriterion("classes_id not in", values, "classesId");
            return (Criteria) this;
        }

        public Criteria andClassesIdBetween(Long value1, Long value2) {
            addCriterion("classes_id between", value1, value2, "classesId");
            return (Criteria) this;
        }

        public Criteria andClassesIdNotBetween(Long value1, Long value2) {
            addCriterion("classes_id not between", value1, value2, "classesId");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Long value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Long value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Long value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Long value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Long value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Long value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Long> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Long> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Long value1, Long value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Long value1, Long value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andStudentMessageIsNull() {
            addCriterion("student_message is null");
            return (Criteria) this;
        }

        public Criteria andStudentMessageIsNotNull() {
            addCriterion("student_message is not null");
            return (Criteria) this;
        }

        public Criteria andStudentMessageEqualTo(String value) {
            addCriterion("student_message =", value, "studentMessage");
            return (Criteria) this;
        }

        public Criteria andStudentMessageNotEqualTo(String value) {
            addCriterion("student_message <>", value, "studentMessage");
            return (Criteria) this;
        }

        public Criteria andStudentMessageGreaterThan(String value) {
            addCriterion("student_message >", value, "studentMessage");
            return (Criteria) this;
        }

        public Criteria andStudentMessageGreaterThanOrEqualTo(String value) {
            addCriterion("student_message >=", value, "studentMessage");
            return (Criteria) this;
        }

        public Criteria andStudentMessageLessThan(String value) {
            addCriterion("student_message <", value, "studentMessage");
            return (Criteria) this;
        }

        public Criteria andStudentMessageLessThanOrEqualTo(String value) {
            addCriterion("student_message <=", value, "studentMessage");
            return (Criteria) this;
        }

        public Criteria andStudentMessageLike(String value) {
            addCriterion("student_message like", value, "studentMessage");
            return (Criteria) this;
        }

        public Criteria andStudentMessageNotLike(String value) {
            addCriterion("student_message not like", value, "studentMessage");
            return (Criteria) this;
        }

        public Criteria andStudentMessageIn(List<String> values) {
            addCriterion("student_message in", values, "studentMessage");
            return (Criteria) this;
        }

        public Criteria andStudentMessageNotIn(List<String> values) {
            addCriterion("student_message not in", values, "studentMessage");
            return (Criteria) this;
        }

        public Criteria andStudentMessageBetween(String value1, String value2) {
            addCriterion("student_message between", value1, value2, "studentMessage");
            return (Criteria) this;
        }

        public Criteria andStudentMessageNotBetween(String value1, String value2) {
            addCriterion("student_message not between", value1, value2, "studentMessage");
            return (Criteria) this;
        }

        public Criteria andWorkDescIsNull() {
            addCriterion("work_desc is null");
            return (Criteria) this;
        }

        public Criteria andWorkDescIsNotNull() {
            addCriterion("work_desc is not null");
            return (Criteria) this;
        }

        public Criteria andWorkDescEqualTo(String value) {
            addCriterion("work_desc =", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescNotEqualTo(String value) {
            addCriterion("work_desc <>", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescGreaterThan(String value) {
            addCriterion("work_desc >", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescGreaterThanOrEqualTo(String value) {
            addCriterion("work_desc >=", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescLessThan(String value) {
            addCriterion("work_desc <", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescLessThanOrEqualTo(String value) {
            addCriterion("work_desc <=", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescLike(String value) {
            addCriterion("work_desc like", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescNotLike(String value) {
            addCriterion("work_desc not like", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescIn(List<String> values) {
            addCriterion("work_desc in", values, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescNotIn(List<String> values) {
            addCriterion("work_desc not in", values, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescBetween(String value1, String value2) {
            addCriterion("work_desc between", value1, value2, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescNotBetween(String value1, String value2) {
            addCriterion("work_desc not between", value1, value2, "workDesc");
            return (Criteria) this;
        }

        public Criteria andPublishNickIsNull() {
            addCriterion("publish_nick is null");
            return (Criteria) this;
        }

        public Criteria andPublishNickIsNotNull() {
            addCriterion("publish_nick is not null");
            return (Criteria) this;
        }

        public Criteria andPublishNickEqualTo(String value) {
            addCriterion("publish_nick =", value, "publishNick");
            return (Criteria) this;
        }

        public Criteria andPublishNickNotEqualTo(String value) {
            addCriterion("publish_nick <>", value, "publishNick");
            return (Criteria) this;
        }

        public Criteria andPublishNickGreaterThan(String value) {
            addCriterion("publish_nick >", value, "publishNick");
            return (Criteria) this;
        }

        public Criteria andPublishNickGreaterThanOrEqualTo(String value) {
            addCriterion("publish_nick >=", value, "publishNick");
            return (Criteria) this;
        }

        public Criteria andPublishNickLessThan(String value) {
            addCriterion("publish_nick <", value, "publishNick");
            return (Criteria) this;
        }

        public Criteria andPublishNickLessThanOrEqualTo(String value) {
            addCriterion("publish_nick <=", value, "publishNick");
            return (Criteria) this;
        }

        public Criteria andPublishNickLike(String value) {
            addCriterion("publish_nick like", value, "publishNick");
            return (Criteria) this;
        }

        public Criteria andPublishNickNotLike(String value) {
            addCriterion("publish_nick not like", value, "publishNick");
            return (Criteria) this;
        }

        public Criteria andPublishNickIn(List<String> values) {
            addCriterion("publish_nick in", values, "publishNick");
            return (Criteria) this;
        }

        public Criteria andPublishNickNotIn(List<String> values) {
            addCriterion("publish_nick not in", values, "publishNick");
            return (Criteria) this;
        }

        public Criteria andPublishNickBetween(String value1, String value2) {
            addCriterion("publish_nick between", value1, value2, "publishNick");
            return (Criteria) this;
        }

        public Criteria andPublishNickNotBetween(String value1, String value2) {
            addCriterion("publish_nick not between", value1, value2, "publishNick");
            return (Criteria) this;
        }

        public Criteria andReferenceFileNameIsNull() {
            addCriterion("reference_file_name is null");
            return (Criteria) this;
        }

        public Criteria andReferenceFileNameIsNotNull() {
            addCriterion("reference_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andReferenceFileNameEqualTo(String value) {
            addCriterion("reference_file_name =", value, "referenceFileName");
            return (Criteria) this;
        }

        public Criteria andReferenceFileNameNotEqualTo(String value) {
            addCriterion("reference_file_name <>", value, "referenceFileName");
            return (Criteria) this;
        }

        public Criteria andReferenceFileNameGreaterThan(String value) {
            addCriterion("reference_file_name >", value, "referenceFileName");
            return (Criteria) this;
        }

        public Criteria andReferenceFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("reference_file_name >=", value, "referenceFileName");
            return (Criteria) this;
        }

        public Criteria andReferenceFileNameLessThan(String value) {
            addCriterion("reference_file_name <", value, "referenceFileName");
            return (Criteria) this;
        }

        public Criteria andReferenceFileNameLessThanOrEqualTo(String value) {
            addCriterion("reference_file_name <=", value, "referenceFileName");
            return (Criteria) this;
        }

        public Criteria andReferenceFileNameLike(String value) {
            addCriterion("reference_file_name like", value, "referenceFileName");
            return (Criteria) this;
        }

        public Criteria andReferenceFileNameNotLike(String value) {
            addCriterion("reference_file_name not like", value, "referenceFileName");
            return (Criteria) this;
        }

        public Criteria andReferenceFileNameIn(List<String> values) {
            addCriterion("reference_file_name in", values, "referenceFileName");
            return (Criteria) this;
        }

        public Criteria andReferenceFileNameNotIn(List<String> values) {
            addCriterion("reference_file_name not in", values, "referenceFileName");
            return (Criteria) this;
        }

        public Criteria andReferenceFileNameBetween(String value1, String value2) {
            addCriterion("reference_file_name between", value1, value2, "referenceFileName");
            return (Criteria) this;
        }

        public Criteria andReferenceFileNameNotBetween(String value1, String value2) {
            addCriterion("reference_file_name not between", value1, value2, "referenceFileName");
            return (Criteria) this;
        }

        public Criteria andReferenceFilePathIsNull() {
            addCriterion("reference_file_path is null");
            return (Criteria) this;
        }

        public Criteria andReferenceFilePathIsNotNull() {
            addCriterion("reference_file_path is not null");
            return (Criteria) this;
        }

        public Criteria andReferenceFilePathEqualTo(String value) {
            addCriterion("reference_file_path =", value, "referenceFilePath");
            return (Criteria) this;
        }

        public Criteria andReferenceFilePathNotEqualTo(String value) {
            addCriterion("reference_file_path <>", value, "referenceFilePath");
            return (Criteria) this;
        }

        public Criteria andReferenceFilePathGreaterThan(String value) {
            addCriterion("reference_file_path >", value, "referenceFilePath");
            return (Criteria) this;
        }

        public Criteria andReferenceFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("reference_file_path >=", value, "referenceFilePath");
            return (Criteria) this;
        }

        public Criteria andReferenceFilePathLessThan(String value) {
            addCriterion("reference_file_path <", value, "referenceFilePath");
            return (Criteria) this;
        }

        public Criteria andReferenceFilePathLessThanOrEqualTo(String value) {
            addCriterion("reference_file_path <=", value, "referenceFilePath");
            return (Criteria) this;
        }

        public Criteria andReferenceFilePathLike(String value) {
            addCriterion("reference_file_path like", value, "referenceFilePath");
            return (Criteria) this;
        }

        public Criteria andReferenceFilePathNotLike(String value) {
            addCriterion("reference_file_path not like", value, "referenceFilePath");
            return (Criteria) this;
        }

        public Criteria andReferenceFilePathIn(List<String> values) {
            addCriterion("reference_file_path in", values, "referenceFilePath");
            return (Criteria) this;
        }

        public Criteria andReferenceFilePathNotIn(List<String> values) {
            addCriterion("reference_file_path not in", values, "referenceFilePath");
            return (Criteria) this;
        }

        public Criteria andReferenceFilePathBetween(String value1, String value2) {
            addCriterion("reference_file_path between", value1, value2, "referenceFilePath");
            return (Criteria) this;
        }

        public Criteria andReferenceFilePathNotBetween(String value1, String value2) {
            addCriterion("reference_file_path not between", value1, value2, "referenceFilePath");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}