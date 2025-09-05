



--
-- Name: jbpm_user_tasks; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE jbpm_user_tasks (
    id character varying(50) NOT NULL,
    user_task_id character varying(255),
    task_priority character varying(50),
    actual_owner character varying(255),
    task_description character varying(255),
    status character varying(255),
    termination_type character varying(255),
    external_reference_id character varying(255),
    task_name character varying(255)
);


--
-- Name: jbpm_user_tasks_admin_groups; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE jbpm_user_tasks_admin_groups (
    task_id character varying(50) NOT NULL,
    group_id character varying(255) NOT NULL
);


--
-- Name: jbpm_user_tasks_admin_users; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE jbpm_user_tasks_admin_users (
    task_id character varying(50) NOT NULL,
    user_id character varying(255) NOT NULL
);


--
-- Name: jbpm_user_tasks_attachments; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE jbpm_user_tasks_attachments (
    id character varying(50) NOT NULL,
    name character varying(255),
    updated_by character varying(255),
    updated_at timestamp(6) without time zone,
    url character varying(255),
    task_id character varying(50) NOT NULL
);


--
-- Name: jbpm_user_tasks_comments; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE jbpm_user_tasks_comments (
    id character varying(50) NOT NULL,
    updated_by character varying(255),
    updated_at timestamp(6) without time zone,
    comment character varying(1000),
    task_id character varying(50) NOT NULL
);


--
-- Name: jbpm_user_tasks_deadline; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE jbpm_user_tasks_deadline (
    id integer NOT NULL,
    task_id character varying(50) NOT NULL,
    notification_type character varying(255) NOT NULL,
    notification_value bytea,
    java_type character varying(255)
);


--
-- Name: jbpm_user_tasks_deadline_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE jbpm_user_tasks_deadline_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: jbpm_user_tasks_deadline_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE jbpm_user_tasks_deadline_seq OWNED BY jbpm_user_tasks_deadline.id;


--
-- Name: jbpm_user_tasks_deadline_timer; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE jbpm_user_tasks_deadline_timer (
    task_id character varying(50) NOT NULL,
    notification_job_id character varying(255) NOT NULL,
    notification_type character varying(255) NOT NULL,
    notification_value bytea,
    java_type character varying(255)
);


--
-- Name: jbpm_user_tasks_excluded_users; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE jbpm_user_tasks_excluded_users (
    task_id character varying(50) NOT NULL,
    user_id character varying(255) NOT NULL
);


--
-- Name: jbpm_user_tasks_inputs; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE jbpm_user_tasks_inputs (
    task_id character varying(50) NOT NULL,
    input_name character varying(255) NOT NULL,
    input_value bytea,
    java_type character varying(255)
);


--
-- Name: jbpm_user_tasks_metadata; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE jbpm_user_tasks_metadata (
    task_id character varying(50) NOT NULL,
    metadata_name character varying(255) NOT NULL,
    metadata_value character varying(512),
    java_type character varying(255)
);


--
-- Name: jbpm_user_tasks_outputs; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE jbpm_user_tasks_outputs (
    task_id character varying(50) NOT NULL,
    output_name character varying(255) NOT NULL,
    output_value bytea,
    java_type character varying(255)
);


--
-- Name: jbpm_user_tasks_potential_groups; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE jbpm_user_tasks_potential_groups (
    task_id character varying(50) NOT NULL,
    group_id character varying(255) NOT NULL
);


--
-- Name: jbpm_user_tasks_potential_users; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE jbpm_user_tasks_potential_users (
    task_id character varying(50) NOT NULL,
    user_id character varying(255) NOT NULL
);


--
-- Name: jbpm_user_tasks_reassignment; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE jbpm_user_tasks_reassignment (
    id integer NOT NULL,
    task_id character varying(50) NOT NULL,
    reassignment_type character varying(255) NOT NULL,
    reassignment_value bytea,
    java_type character varying(255)
);


--
-- Name: jbpm_user_tasks_reassignment_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE jbpm_user_tasks_reassignment_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: jbpm_user_tasks_reassignment_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE jbpm_user_tasks_reassignment_seq OWNED BY jbpm_user_tasks_reassignment.id;


--
-- Name: jbpm_user_tasks_reassignment_timer; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE jbpm_user_tasks_reassignment_timer (
    task_id character varying(50) NOT NULL,
    reassignment_job_id character varying(255) NOT NULL,
    reassignment_type character varying(255) NOT NULL,
    reassignment_value bytea,
    java_type character varying(255)
);


--
-- Name: jbpm_user_tasks_admin_groups jbpm_user_tasks_admin_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_admin_groups
    ADD CONSTRAINT jbpm_user_tasks_admin_groups_pkey PRIMARY KEY (task_id, group_id);


--
-- Name: jbpm_user_tasks_admin_users jbpm_user_tasks_admin_users_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_admin_users
    ADD CONSTRAINT jbpm_user_tasks_admin_users_pkey PRIMARY KEY (task_id, user_id);


--
-- Name: jbpm_user_tasks_attachments jbpm_user_tasks_attachments_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_attachments
    ADD CONSTRAINT jbpm_user_tasks_attachments_pkey PRIMARY KEY (id);


--
-- Name: jbpm_user_tasks_comments jbpm_user_tasks_comments_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_comments
    ADD CONSTRAINT jbpm_user_tasks_comments_pkey PRIMARY KEY (id);


--
-- Name: jbpm_user_tasks_deadline jbpm_user_tasks_deadline_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_deadline
    ADD CONSTRAINT jbpm_user_tasks_deadline_pkey PRIMARY KEY (id);


--
-- Name: jbpm_user_tasks_deadline_timer jbpm_user_tasks_deadline_timer_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_deadline_timer
    ADD CONSTRAINT jbpm_user_tasks_deadline_timer_pkey PRIMARY KEY (task_id, notification_job_id);


--
-- Name: jbpm_user_tasks_excluded_users jbpm_user_tasks_excluded_users_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_excluded_users
    ADD CONSTRAINT jbpm_user_tasks_excluded_users_pkey PRIMARY KEY (task_id, user_id);


--
-- Name: jbpm_user_tasks_inputs jbpm_user_tasks_inputs_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_inputs
    ADD CONSTRAINT jbpm_user_tasks_inputs_pkey PRIMARY KEY (task_id, input_name);


--
-- Name: jbpm_user_tasks_metadata jbpm_user_tasks_metadata_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_metadata
    ADD CONSTRAINT jbpm_user_tasks_metadata_pkey PRIMARY KEY (task_id, metadata_name);


--
-- Name: jbpm_user_tasks_outputs jbpm_user_tasks_outputs_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_outputs
    ADD CONSTRAINT jbpm_user_tasks_outputs_pkey PRIMARY KEY (task_id, output_name);


--
-- Name: jbpm_user_tasks jbpm_user_tasks_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks
    ADD CONSTRAINT jbpm_user_tasks_pkey PRIMARY KEY (id);


--
-- Name: jbpm_user_tasks_potential_groups jbpm_user_tasks_potential_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_potential_groups
    ADD CONSTRAINT jbpm_user_tasks_potential_groups_pkey PRIMARY KEY (task_id, group_id);


--
-- Name: jbpm_user_tasks_potential_users jbpm_user_tasks_potential_users_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_potential_users
    ADD CONSTRAINT jbpm_user_tasks_potential_users_pkey PRIMARY KEY (task_id, user_id);


--
-- Name: jbpm_user_tasks_reassignment jbpm_user_tasks_reassignment_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_reassignment
    ADD CONSTRAINT jbpm_user_tasks_reassignment_pkey PRIMARY KEY (id);


--
-- Name: jbpm_user_tasks_reassignment_timer jbpm_user_tasks_reassignment_timer_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_reassignment_timer
    ADD CONSTRAINT jbpm_user_tasks_reassignment_timer_pkey PRIMARY KEY (task_id, reassignment_job_id);


--
-- Name: idx_jbpm_user_tasks_admin_groups_gid; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX idx_jbpm_user_tasks_admin_groups_gid ON jbpm_user_tasks_admin_groups USING btree (group_id);


--
-- Name: idx_jbpm_user_tasks_admin_groups_tid; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX idx_jbpm_user_tasks_admin_groups_tid ON jbpm_user_tasks_admin_groups USING btree (task_id);


--
-- Name: idx_jbpm_user_tasks_admin_users_tid; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX idx_jbpm_user_tasks_admin_users_tid ON jbpm_user_tasks_admin_users USING btree (task_id);


--
-- Name: idx_jbpm_user_tasks_admin_users_uid; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX idx_jbpm_user_tasks_admin_users_uid ON jbpm_user_tasks_admin_users USING btree (user_id);


--
-- Name: idx_jbpm_user_tasks_attachments_tid; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX idx_jbpm_user_tasks_attachments_tid ON jbpm_user_tasks_attachments USING btree (task_id);


--
-- Name: idx_jbpm_user_tasks_deadline_tid; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX idx_jbpm_user_tasks_deadline_tid ON jbpm_user_tasks_deadline USING btree (task_id);


--
-- Name: idx_jbpm_user_tasks_excluded_users_tid; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX idx_jbpm_user_tasks_excluded_users_tid ON jbpm_user_tasks_excluded_users USING btree (task_id);


--
-- Name: idx_jbpm_user_tasks_excluded_users_uid; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX idx_jbpm_user_tasks_excluded_users_uid ON jbpm_user_tasks_excluded_users USING btree (user_id);


--
-- Name: idx_jbpm_user_tasks_inputs_tid; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX idx_jbpm_user_tasks_inputs_tid ON jbpm_user_tasks_inputs USING btree (task_id);


--
-- Name: idx_jbpm_user_tasks_metadata_tid; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX idx_jbpm_user_tasks_metadata_tid ON jbpm_user_tasks_metadata USING btree (task_id);


--
-- Name: idx_jbpm_user_tasks_outputs_tid; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX idx_jbpm_user_tasks_outputs_tid ON jbpm_user_tasks_outputs USING btree (task_id);


--
-- Name: idx_jbpm_user_tasks_potential_groups_gid; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX idx_jbpm_user_tasks_potential_groups_gid ON jbpm_user_tasks_potential_groups USING btree (group_id);


--
-- Name: idx_jbpm_user_tasks_potential_groups_tid; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX idx_jbpm_user_tasks_potential_groups_tid ON jbpm_user_tasks_potential_groups USING btree (task_id);


--
-- Name: idx_jbpm_user_tasks_potential_users_tid; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX idx_jbpm_user_tasks_potential_users_tid ON jbpm_user_tasks_potential_users USING btree (task_id);


--
-- Name: idx_jbpm_user_tasks_potential_users_uid; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX idx_jbpm_user_tasks_potential_users_uid ON jbpm_user_tasks_potential_users USING btree (user_id);


--
-- Name: idx_usertasks_tid; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX idx_usertasks_tid ON jbpm_user_tasks USING btree (user_task_id);


--
-- Name: jbpm_user_tasks_potential_users fk_jbpm_user_fk_tasks_potential_users_tid; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_potential_users
    ADD CONSTRAINT fk_jbpm_user_fk_tasks_potential_users_tid FOREIGN KEY (task_id) REFERENCES jbpm_user_tasks(id) ON DELETE CASCADE;


--
-- Name: jbpm_user_tasks_admin_groups fk_jbpm_user_tasks_admin_groups_tid; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_admin_groups
    ADD CONSTRAINT fk_jbpm_user_tasks_admin_groups_tid FOREIGN KEY (task_id) REFERENCES jbpm_user_tasks(id) ON DELETE CASCADE;


--
-- Name: jbpm_user_tasks_admin_users fk_jbpm_user_tasks_admin_users_tid; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_admin_users
    ADD CONSTRAINT fk_jbpm_user_tasks_admin_users_tid FOREIGN KEY (task_id) REFERENCES jbpm_user_tasks(id) ON DELETE CASCADE;


--
-- Name: jbpm_user_tasks_deadline fk_jbpm_user_tasks_deadline_tid; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_deadline
    ADD CONSTRAINT fk_jbpm_user_tasks_deadline_tid FOREIGN KEY (task_id) REFERENCES jbpm_user_tasks(id) ON DELETE CASCADE;


--
-- Name: jbpm_user_tasks_deadline_timer fk_jbpm_user_tasks_deadline_timer_tid; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_deadline_timer
    ADD CONSTRAINT fk_jbpm_user_tasks_deadline_timer_tid FOREIGN KEY (task_id) REFERENCES jbpm_user_tasks(id) ON DELETE CASCADE;


--
-- Name: jbpm_user_tasks_excluded_users fk_jbpm_user_tasks_excluded_users_tid; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_excluded_users
    ADD CONSTRAINT fk_jbpm_user_tasks_excluded_users_tid FOREIGN KEY (task_id) REFERENCES jbpm_user_tasks(id) ON DELETE CASCADE;


--
-- Name: jbpm_user_tasks_inputs fk_jbpm_user_tasks_inputs_tid; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_inputs
    ADD CONSTRAINT fk_jbpm_user_tasks_inputs_tid FOREIGN KEY (task_id) REFERENCES jbpm_user_tasks(id) ON DELETE CASCADE;


--
-- Name: jbpm_user_tasks_metadata fk_jbpm_user_tasks_metadata_tid; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_metadata
    ADD CONSTRAINT fk_jbpm_user_tasks_metadata_tid FOREIGN KEY (task_id) REFERENCES jbpm_user_tasks(id) ON DELETE CASCADE;


--
-- Name: jbpm_user_tasks_outputs fk_jbpm_user_tasks_outputs_tid; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_outputs
    ADD CONSTRAINT fk_jbpm_user_tasks_outputs_tid FOREIGN KEY (task_id) REFERENCES jbpm_user_tasks(id) ON DELETE CASCADE;


--
-- Name: jbpm_user_tasks_potential_groups fk_jbpm_user_tasks_potential_groups_tid; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_potential_groups
    ADD CONSTRAINT fk_jbpm_user_tasks_potential_groups_tid FOREIGN KEY (task_id) REFERENCES jbpm_user_tasks(id) ON DELETE CASCADE;


--
-- Name: jbpm_user_tasks_reassignment fk_jbpm_user_tasks_reassignment_tid; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_reassignment
    ADD CONSTRAINT fk_jbpm_user_tasks_reassignment_tid FOREIGN KEY (task_id) REFERENCES jbpm_user_tasks(id) ON DELETE CASCADE;


--
-- Name: jbpm_user_tasks_reassignment_timer fk_jbpm_user_tasks_reassignment_timer_tid; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_reassignment_timer
    ADD CONSTRAINT fk_jbpm_user_tasks_reassignment_timer_tid FOREIGN KEY (task_id) REFERENCES jbpm_user_tasks(id) ON DELETE CASCADE;


--
-- Name: jbpm_user_tasks_attachments fk_user_tasks_attachments_tid; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_attachments
    ADD CONSTRAINT fk_user_tasks_attachments_tid FOREIGN KEY (task_id) REFERENCES jbpm_user_tasks(id) ON DELETE CASCADE;


--
-- Name: jbpm_user_tasks_comments fk_user_tasks_comments_tid; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY jbpm_user_tasks_comments
    ADD CONSTRAINT fk_user_tasks_comments_tid FOREIGN KEY (task_id) REFERENCES jbpm_user_tasks(id) ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

