package org.zzd.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysAttachmentsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysAttachmentsExample() {
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

        public Criteria andAttachmentsTypeIsNull() {
            addCriterion("attachments_type_ is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentsTypeIsNotNull() {
            addCriterion("attachments_type_ is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentsTypeEqualTo(String value) {
            addCriterion("attachments_type_ =", value, "attachmentsType");
            return (Criteria) this;
        }

        public Criteria andAttachmentsTypeNotEqualTo(String value) {
            addCriterion("attachments_type_ <>", value, "attachmentsType");
            return (Criteria) this;
        }

        public Criteria andAttachmentsTypeGreaterThan(String value) {
            addCriterion("attachments_type_ >", value, "attachmentsType");
            return (Criteria) this;
        }

        public Criteria andAttachmentsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("attachments_type_ >=", value, "attachmentsType");
            return (Criteria) this;
        }

        public Criteria andAttachmentsTypeLessThan(String value) {
            addCriterion("attachments_type_ <", value, "attachmentsType");
            return (Criteria) this;
        }

        public Criteria andAttachmentsTypeLessThanOrEqualTo(String value) {
            addCriterion("attachments_type_ <=", value, "attachmentsType");
            return (Criteria) this;
        }

        public Criteria andAttachmentsTypeLike(String value) {
            addCriterion("attachments_type_ like", value, "attachmentsType");
            return (Criteria) this;
        }

        public Criteria andAttachmentsTypeNotLike(String value) {
            addCriterion("attachments_type_ not like", value, "attachmentsType");
            return (Criteria) this;
        }

        public Criteria andAttachmentsTypeIn(List<String> values) {
            addCriterion("attachments_type_ in", values, "attachmentsType");
            return (Criteria) this;
        }

        public Criteria andAttachmentsTypeNotIn(List<String> values) {
            addCriterion("attachments_type_ not in", values, "attachmentsType");
            return (Criteria) this;
        }

        public Criteria andAttachmentsTypeBetween(String value1, String value2) {
            addCriterion("attachments_type_ between", value1, value2, "attachmentsType");
            return (Criteria) this;
        }

        public Criteria andAttachmentsTypeNotBetween(String value1, String value2) {
            addCriterion("attachments_type_ not between", value1, value2, "attachmentsType");
            return (Criteria) this;
        }

        public Criteria andServicePathIsNull() {
            addCriterion("service_path_ is null");
            return (Criteria) this;
        }

        public Criteria andServicePathIsNotNull() {
            addCriterion("service_path_ is not null");
            return (Criteria) this;
        }

        public Criteria andServicePathEqualTo(String value) {
            addCriterion("service_path_ =", value, "servicePath");
            return (Criteria) this;
        }

        public Criteria andServicePathNotEqualTo(String value) {
            addCriterion("service_path_ <>", value, "servicePath");
            return (Criteria) this;
        }

        public Criteria andServicePathGreaterThan(String value) {
            addCriterion("service_path_ >", value, "servicePath");
            return (Criteria) this;
        }

        public Criteria andServicePathGreaterThanOrEqualTo(String value) {
            addCriterion("service_path_ >=", value, "servicePath");
            return (Criteria) this;
        }

        public Criteria andServicePathLessThan(String value) {
            addCriterion("service_path_ <", value, "servicePath");
            return (Criteria) this;
        }

        public Criteria andServicePathLessThanOrEqualTo(String value) {
            addCriterion("service_path_ <=", value, "servicePath");
            return (Criteria) this;
        }

        public Criteria andServicePathLike(String value) {
            addCriterion("service_path_ like", value, "servicePath");
            return (Criteria) this;
        }

        public Criteria andServicePathNotLike(String value) {
            addCriterion("service_path_ not like", value, "servicePath");
            return (Criteria) this;
        }

        public Criteria andServicePathIn(List<String> values) {
            addCriterion("service_path_ in", values, "servicePath");
            return (Criteria) this;
        }

        public Criteria andServicePathNotIn(List<String> values) {
            addCriterion("service_path_ not in", values, "servicePath");
            return (Criteria) this;
        }

        public Criteria andServicePathBetween(String value1, String value2) {
            addCriterion("service_path_ between", value1, value2, "servicePath");
            return (Criteria) this;
        }

        public Criteria andServicePathNotBetween(String value1, String value2) {
            addCriterion("service_path_ not between", value1, value2, "servicePath");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNull() {
            addCriterion("app_name_ is null");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNotNull() {
            addCriterion("app_name_ is not null");
            return (Criteria) this;
        }

        public Criteria andAppNameEqualTo(String value) {
            addCriterion("app_name_ =", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotEqualTo(String value) {
            addCriterion("app_name_ <>", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThan(String value) {
            addCriterion("app_name_ >", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("app_name_ >=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThan(String value) {
            addCriterion("app_name_ <", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThanOrEqualTo(String value) {
            addCriterion("app_name_ <=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLike(String value) {
            addCriterion("app_name_ like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotLike(String value) {
            addCriterion("app_name_ not like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameIn(List<String> values) {
            addCriterion("app_name_ in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotIn(List<String> values) {
            addCriterion("app_name_ not in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameBetween(String value1, String value2) {
            addCriterion("app_name_ between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotBetween(String value1, String value2) {
            addCriterion("app_name_ not between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andUploadAppNameIsNull() {
            addCriterion("upload_app_name_ is null");
            return (Criteria) this;
        }

        public Criteria andUploadAppNameIsNotNull() {
            addCriterion("upload_app_name_ is not null");
            return (Criteria) this;
        }

        public Criteria andUploadAppNameEqualTo(String value) {
            addCriterion("upload_app_name_ =", value, "uploadAppName");
            return (Criteria) this;
        }

        public Criteria andUploadAppNameNotEqualTo(String value) {
            addCriterion("upload_app_name_ <>", value, "uploadAppName");
            return (Criteria) this;
        }

        public Criteria andUploadAppNameGreaterThan(String value) {
            addCriterion("upload_app_name_ >", value, "uploadAppName");
            return (Criteria) this;
        }

        public Criteria andUploadAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("upload_app_name_ >=", value, "uploadAppName");
            return (Criteria) this;
        }

        public Criteria andUploadAppNameLessThan(String value) {
            addCriterion("upload_app_name_ <", value, "uploadAppName");
            return (Criteria) this;
        }

        public Criteria andUploadAppNameLessThanOrEqualTo(String value) {
            addCriterion("upload_app_name_ <=", value, "uploadAppName");
            return (Criteria) this;
        }

        public Criteria andUploadAppNameLike(String value) {
            addCriterion("upload_app_name_ like", value, "uploadAppName");
            return (Criteria) this;
        }

        public Criteria andUploadAppNameNotLike(String value) {
            addCriterion("upload_app_name_ not like", value, "uploadAppName");
            return (Criteria) this;
        }

        public Criteria andUploadAppNameIn(List<String> values) {
            addCriterion("upload_app_name_ in", values, "uploadAppName");
            return (Criteria) this;
        }

        public Criteria andUploadAppNameNotIn(List<String> values) {
            addCriterion("upload_app_name_ not in", values, "uploadAppName");
            return (Criteria) this;
        }

        public Criteria andUploadAppNameBetween(String value1, String value2) {
            addCriterion("upload_app_name_ between", value1, value2, "uploadAppName");
            return (Criteria) this;
        }

        public Criteria andUploadAppNameNotBetween(String value1, String value2) {
            addCriterion("upload_app_name_ not between", value1, value2, "uploadAppName");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathIsNull() {
            addCriterion("attachment_path_ is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathIsNotNull() {
            addCriterion("attachment_path_ is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathEqualTo(String value) {
            addCriterion("attachment_path_ =", value, "attachmentPath");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathNotEqualTo(String value) {
            addCriterion("attachment_path_ <>", value, "attachmentPath");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathGreaterThan(String value) {
            addCriterion("attachment_path_ >", value, "attachmentPath");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathGreaterThanOrEqualTo(String value) {
            addCriterion("attachment_path_ >=", value, "attachmentPath");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathLessThan(String value) {
            addCriterion("attachment_path_ <", value, "attachmentPath");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathLessThanOrEqualTo(String value) {
            addCriterion("attachment_path_ <=", value, "attachmentPath");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathLike(String value) {
            addCriterion("attachment_path_ like", value, "attachmentPath");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathNotLike(String value) {
            addCriterion("attachment_path_ not like", value, "attachmentPath");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathIn(List<String> values) {
            addCriterion("attachment_path_ in", values, "attachmentPath");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathNotIn(List<String> values) {
            addCriterion("attachment_path_ not in", values, "attachmentPath");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathBetween(String value1, String value2) {
            addCriterion("attachment_path_ between", value1, value2, "attachmentPath");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathNotBetween(String value1, String value2) {
            addCriterion("attachment_path_ not between", value1, value2, "attachmentPath");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameIsNull() {
            addCriterion("attachment_name_ is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameIsNotNull() {
            addCriterion("attachment_name_ is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameEqualTo(String value) {
            addCriterion("attachment_name_ =", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameNotEqualTo(String value) {
            addCriterion("attachment_name_ <>", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameGreaterThan(String value) {
            addCriterion("attachment_name_ >", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("attachment_name_ >=", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameLessThan(String value) {
            addCriterion("attachment_name_ <", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameLessThanOrEqualTo(String value) {
            addCriterion("attachment_name_ <=", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameLike(String value) {
            addCriterion("attachment_name_ like", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameNotLike(String value) {
            addCriterion("attachment_name_ not like", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameIn(List<String> values) {
            addCriterion("attachment_name_ in", values, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameNotIn(List<String> values) {
            addCriterion("attachment_name_ not in", values, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameBetween(String value1, String value2) {
            addCriterion("attachment_name_ between", value1, value2, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameNotBetween(String value1, String value2) {
            addCriterion("attachment_name_ not between", value1, value2, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentSizeIsNull() {
            addCriterion("attachment_size_ is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentSizeIsNotNull() {
            addCriterion("attachment_size_ is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentSizeEqualTo(String value) {
            addCriterion("attachment_size_ =", value, "attachmentSize");
            return (Criteria) this;
        }

        public Criteria andAttachmentSizeNotEqualTo(String value) {
            addCriterion("attachment_size_ <>", value, "attachmentSize");
            return (Criteria) this;
        }

        public Criteria andAttachmentSizeGreaterThan(String value) {
            addCriterion("attachment_size_ >", value, "attachmentSize");
            return (Criteria) this;
        }

        public Criteria andAttachmentSizeGreaterThanOrEqualTo(String value) {
            addCriterion("attachment_size_ >=", value, "attachmentSize");
            return (Criteria) this;
        }

        public Criteria andAttachmentSizeLessThan(String value) {
            addCriterion("attachment_size_ <", value, "attachmentSize");
            return (Criteria) this;
        }

        public Criteria andAttachmentSizeLessThanOrEqualTo(String value) {
            addCriterion("attachment_size_ <=", value, "attachmentSize");
            return (Criteria) this;
        }

        public Criteria andAttachmentSizeLike(String value) {
            addCriterion("attachment_size_ like", value, "attachmentSize");
            return (Criteria) this;
        }

        public Criteria andAttachmentSizeNotLike(String value) {
            addCriterion("attachment_size_ not like", value, "attachmentSize");
            return (Criteria) this;
        }

        public Criteria andAttachmentSizeIn(List<String> values) {
            addCriterion("attachment_size_ in", values, "attachmentSize");
            return (Criteria) this;
        }

        public Criteria andAttachmentSizeNotIn(List<String> values) {
            addCriterion("attachment_size_ not in", values, "attachmentSize");
            return (Criteria) this;
        }

        public Criteria andAttachmentSizeBetween(String value1, String value2) {
            addCriterion("attachment_size_ between", value1, value2, "attachmentSize");
            return (Criteria) this;
        }

        public Criteria andAttachmentSizeNotBetween(String value1, String value2) {
            addCriterion("attachment_size_ not between", value1, value2, "attachmentSize");
            return (Criteria) this;
        }

        public Criteria andAttachmentFormatIsNull() {
            addCriterion("attachment_format_ is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentFormatIsNotNull() {
            addCriterion("attachment_format_ is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentFormatEqualTo(String value) {
            addCriterion("attachment_format_ =", value, "attachmentFormat");
            return (Criteria) this;
        }

        public Criteria andAttachmentFormatNotEqualTo(String value) {
            addCriterion("attachment_format_ <>", value, "attachmentFormat");
            return (Criteria) this;
        }

        public Criteria andAttachmentFormatGreaterThan(String value) {
            addCriterion("attachment_format_ >", value, "attachmentFormat");
            return (Criteria) this;
        }

        public Criteria andAttachmentFormatGreaterThanOrEqualTo(String value) {
            addCriterion("attachment_format_ >=", value, "attachmentFormat");
            return (Criteria) this;
        }

        public Criteria andAttachmentFormatLessThan(String value) {
            addCriterion("attachment_format_ <", value, "attachmentFormat");
            return (Criteria) this;
        }

        public Criteria andAttachmentFormatLessThanOrEqualTo(String value) {
            addCriterion("attachment_format_ <=", value, "attachmentFormat");
            return (Criteria) this;
        }

        public Criteria andAttachmentFormatLike(String value) {
            addCriterion("attachment_format_ like", value, "attachmentFormat");
            return (Criteria) this;
        }

        public Criteria andAttachmentFormatNotLike(String value) {
            addCriterion("attachment_format_ not like", value, "attachmentFormat");
            return (Criteria) this;
        }

        public Criteria andAttachmentFormatIn(List<String> values) {
            addCriterion("attachment_format_ in", values, "attachmentFormat");
            return (Criteria) this;
        }

        public Criteria andAttachmentFormatNotIn(List<String> values) {
            addCriterion("attachment_format_ not in", values, "attachmentFormat");
            return (Criteria) this;
        }

        public Criteria andAttachmentFormatBetween(String value1, String value2) {
            addCriterion("attachment_format_ between", value1, value2, "attachmentFormat");
            return (Criteria) this;
        }

        public Criteria andAttachmentFormatNotBetween(String value1, String value2) {
            addCriterion("attachment_format_ not between", value1, value2, "attachmentFormat");
            return (Criteria) this;
        }

        public Criteria andOpTimeIsNull() {
            addCriterion("op_time_ is null");
            return (Criteria) this;
        }

        public Criteria andOpTimeIsNotNull() {
            addCriterion("op_time_ is not null");
            return (Criteria) this;
        }

        public Criteria andOpTimeEqualTo(Date value) {
            addCriterion("op_time_ =", value, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeNotEqualTo(Date value) {
            addCriterion("op_time_ <>", value, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeGreaterThan(Date value) {
            addCriterion("op_time_ >", value, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("op_time_ >=", value, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeLessThan(Date value) {
            addCriterion("op_time_ <", value, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeLessThanOrEqualTo(Date value) {
            addCriterion("op_time_ <=", value, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeIn(List<Date> values) {
            addCriterion("op_time_ in", values, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeNotIn(List<Date> values) {
            addCriterion("op_time_ not in", values, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeBetween(Date value1, Date value2) {
            addCriterion("op_time_ between", value1, value2, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeNotBetween(Date value1, Date value2) {
            addCriterion("op_time_ not between", value1, value2, "opTime");
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