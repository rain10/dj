package org.zzd.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MembersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MembersExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id_ is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id_ is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id_ =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id_ <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id_ >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id_ >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id_ <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id_ <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id_ in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id_ not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id_ between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id_ not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username_ is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username_ is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username_ =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username_ <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username_ >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username_ >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username_ <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username_ <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username_ like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username_ not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username_ in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username_ not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username_ between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username_ not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password_ is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password_ is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password_ =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password_ <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password_ >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password_ >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password_ <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password_ <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password_ like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password_ not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password_ in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password_ not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password_ between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password_ not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname_ is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname_ is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname_ =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname_ <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname_ >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname_ >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname_ <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname_ <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname_ like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname_ not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname_ in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname_ not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname_ between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname_ not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex_ is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex_ is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex_ =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex_ <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex_ >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex_ >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex_ <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex_ <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex_ like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex_ not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex_ in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex_ not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex_ between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex_ not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSignatureIsNull() {
            addCriterion("signature_ is null");
            return (Criteria) this;
        }

        public Criteria andSignatureIsNotNull() {
            addCriterion("signature_ is not null");
            return (Criteria) this;
        }

        public Criteria andSignatureEqualTo(String value) {
            addCriterion("signature_ =", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotEqualTo(String value) {
            addCriterion("signature_ <>", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureGreaterThan(String value) {
            addCriterion("signature_ >", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("signature_ >=", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLessThan(String value) {
            addCriterion("signature_ <", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLessThanOrEqualTo(String value) {
            addCriterion("signature_ <=", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLike(String value) {
            addCriterion("signature_ like", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotLike(String value) {
            addCriterion("signature_ not like", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureIn(List<String> values) {
            addCriterion("signature_ in", values, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotIn(List<String> values) {
            addCriterion("signature_ not in", values, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureBetween(String value1, String value2) {
            addCriterion("signature_ between", value1, value2, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotBetween(String value1, String value2) {
            addCriterion("signature_ not between", value1, value2, "signature");
            return (Criteria) this;
        }

        public Criteria andAttachmentsIdIsNull() {
            addCriterion("attachments_id_ is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentsIdIsNotNull() {
            addCriterion("attachments_id_ is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentsIdEqualTo(Long value) {
            addCriterion("attachments_id_ =", value, "attachmentsId");
            return (Criteria) this;
        }

        public Criteria andAttachmentsIdNotEqualTo(Long value) {
            addCriterion("attachments_id_ <>", value, "attachmentsId");
            return (Criteria) this;
        }

        public Criteria andAttachmentsIdGreaterThan(Long value) {
            addCriterion("attachments_id_ >", value, "attachmentsId");
            return (Criteria) this;
        }

        public Criteria andAttachmentsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("attachments_id_ >=", value, "attachmentsId");
            return (Criteria) this;
        }

        public Criteria andAttachmentsIdLessThan(Long value) {
            addCriterion("attachments_id_ <", value, "attachmentsId");
            return (Criteria) this;
        }

        public Criteria andAttachmentsIdLessThanOrEqualTo(Long value) {
            addCriterion("attachments_id_ <=", value, "attachmentsId");
            return (Criteria) this;
        }

        public Criteria andAttachmentsIdIn(List<Long> values) {
            addCriterion("attachments_id_ in", values, "attachmentsId");
            return (Criteria) this;
        }

        public Criteria andAttachmentsIdNotIn(List<Long> values) {
            addCriterion("attachments_id_ not in", values, "attachmentsId");
            return (Criteria) this;
        }

        public Criteria andAttachmentsIdBetween(Long value1, Long value2) {
            addCriterion("attachments_id_ between", value1, value2, "attachmentsId");
            return (Criteria) this;
        }

        public Criteria andAttachmentsIdNotBetween(Long value1, Long value2) {
            addCriterion("attachments_id_ not between", value1, value2, "attachmentsId");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNull() {
            addCriterion("enabled_ is null");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNotNull() {
            addCriterion("enabled_ is not null");
            return (Criteria) this;
        }

        public Criteria andEnabledEqualTo(Integer value) {
            addCriterion("enabled_ =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(Integer value) {
            addCriterion("enabled_ <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(Integer value) {
            addCriterion("enabled_ >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Integer value) {
            addCriterion("enabled_ >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(Integer value) {
            addCriterion("enabled_ <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Integer value) {
            addCriterion("enabled_ <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<Integer> values) {
            addCriterion("enabled_ in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<Integer> values) {
            addCriterion("enabled_ not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(Integer value1, Integer value2) {
            addCriterion("enabled_ between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(Integer value1, Integer value2) {
            addCriterion("enabled_ not between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNull() {
            addCriterion("register_time_ is null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNotNull() {
            addCriterion("register_time_ is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeEqualTo(Date value) {
            addCriterion("register_time_ =", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotEqualTo(Date value) {
            addCriterion("register_time_ <>", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThan(Date value) {
            addCriterion("register_time_ >", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("register_time_ >=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThan(Date value) {
            addCriterion("register_time_ <", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThanOrEqualTo(Date value) {
            addCriterion("register_time_ <=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIn(List<Date> values) {
            addCriterion("register_time_ in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotIn(List<Date> values) {
            addCriterion("register_time_ not in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeBetween(Date value1, Date value2) {
            addCriterion("register_time_ between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotBetween(Date value1, Date value2) {
            addCriterion("register_time_ not between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("last_login_time_ is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("last_login_time_ is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(Date value) {
            addCriterion("last_login_time_ =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(Date value) {
            addCriterion("last_login_time_ <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(Date value) {
            addCriterion("last_login_time_ >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_login_time_ >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(Date value) {
            addCriterion("last_login_time_ <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_login_time_ <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(List<Date> values) {
            addCriterion("last_login_time_ in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(List<Date> values) {
            addCriterion("last_login_time_ not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(Date value1, Date value2) {
            addCriterion("last_login_time_ between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_login_time_ not between", value1, value2, "lastLoginTime");
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