# Assignment Evaluation And Grading Process

## Purpose

This document explains the grading rules students need to know for course assignments.

It is assignment-agnostic. Technical rubrics, conversion tables, and assignment-specific bonus rules are defined in separate assignment documents.

Interpretation rule:

- `assignment_evaluation_process.md` defines course-level grading policy
- `evaluation_instructions.md` defines evaluator workflow and document-handling rules
- assignment-specific documents define the technical rubric, internal-mark structure, conversion rules, and assignment-specific gates

## Course-Level Structure

- Total number of assignments: `7`
- Total maximum number of grading points across the course: `30`
- Each assignment is worth between `3` and `5` regular grading points, depending on the assignment

The exact regular point value of each assignment must be defined in that assignment's grading criteria.

## Deadlines

Each assignment has two deadlines:

- `soft deadline`
- `hard deadline`

Rule:

- the hard deadline is exactly `1 week` after the soft deadline
- both deadlines apply to the first submission only

Late-submission rule:

- submissions after the hard deadline are ignored

## How Your Result Is Built

Your result for one assignment may include up to four separate parts:

1. regular grading points from the assignment-specific conversion of internal marks
2. `+1` point for submission before the soft deadline
3. `+1` point if the first evaluated submission receives an internal mark of `90+`
4. assignment-specific `+1` bonus point, if that assignment defines one and you earn it

## Internal Marks

All assignments are first evaluated using internal marks.

Range:

- `0-100`

Purpose:

- internal marks are the detailed scoring layer
- grading points are the course-result layer

Internal marks are converted into regular assignment points using the conversion table defined for that specific assignment.

## Course-Level Bonuses

### Early Submission Bonus

If you submit before the soft deadline, you earn:

- `+1 grading point`

This is separate from assignment-quality scoring.

Important:

- this bonus applies only to the first submission
- a later rework submission does not receive a separate early-submission bonus

### Strong First-Submission Bonus

If your first evaluated submission receives an internal mark of `90+`, you earn:

- `+1 grading point`

Important:

- this rule depends on the first evaluated submission only
- later improvements do not newly create eligibility if the first evaluated submission was below `90`

## Assignment-Specific Bonus

An assignment may also define its own separate `+1` bonus for extra work or especially strong execution.

That bonus:

- is defined inside the assignment materials
- is separate from the two course-level bonuses above

## Rework And Final Re-evaluation

After receiving an evaluation, you have `1` opportunity to fix the reported problems and submit an updated version.

Rules:

- only one post-evaluation resubmission is allowed per assignment
- the updated submission should address the problems identified in the evaluation
- after the updated submission is received, a final re-evaluation is performed
- the final re-evaluation may raise or lower the regular assignment result
- the final re-evaluation may also change the assignment-specific bonus decision
- deadline-based rules and bonuses apply only to the first submission, not to the rework submission
- the course-level first-submission `90+` bonus still depends only on the first evaluated submission
- the result after final re-evaluation is the final result for that assignment

## Evaluation Artifact Separation

Evaluation documents must stay separate by role.

Required separation:

- review = evidence
- grading = scoring derived only from the corresponding review
- fix instructions = remediation derived from the review
- final review = evidence for the updated submission
- final grading = scoring derived only from the corresponding final review

Graders must not introduce new repository findings during grading that are absent from the review the grading is based on.

## Evaluation Artifact Naming

Evaluation artifacts must use assignment-prefixed filenames.

Pattern:

- `A{N}_review.md`
- `A{N}_grading.md`
- `A{N}_fix_instructions.md`
- `A{N}_final_review.md`
- `A{N}_final_grading.md`

This keeps evaluation artifacts unambiguous when one repository contains work for multiple assignments.

## What Assignment-Specific Documents Must Define

Each assignment's own grading document must state clearly:

- the regular point value of the assignment
- the internal-mark rubric
- the conversion from internal marks to regular grading points
- whether the assignment has its own bonus point
- any assignment-specific gating rules or special scoring conditions
- whether any deliverable, including a report, requires a specific file format

If an assignment-specific document does not explicitly require a particular report format, report presence should be evaluated format-agnostically.

That means a report may count as present in formats such as:

- `pdf`
- `md`
- `doc`
- `docx`
- `txt`

Format, presence, and quality are separate decisions:

- a report may be present but weak
- a report may be present in a non-preferred format
- a report is missing only when no relevant report artifact is actually present
- `README.md` is only a candidate report and must be judged by content if it is the only candidate
- a repository note or placeholder `README.md` does not count as a report by filename alone

Build-tool rule:

- missing Maven/Gradle must not be treated as a grading defect by itself unless the assignment-specific documents explicitly make build tooling part of the baseline requirements

## Grading Output Requirements

Each grading output must explicitly record all relevant scoring decisions rather than leaving them implicit.

At minimum, that includes:

- regular-grade conversion from the recorded internal mark
- early-submission decision
- first-submission `90+` decision
- assignment-specific bonus decision
- any relevant assignment-specific gating rules

If a rule cannot be decided from available evidence, the grading output should say so explicitly rather than silently defaulting it to `0`.

Consistency requirements:

- the recorded final result must match the separately listed components exactly
- if an assignment uses visible internal-mark categories, the recorded base internal mark must match the visible category arithmetic

## Short Examples

### Example 1

- Assignment regular value: `4` points
- Internal mark: `93`
- Converted regular grade: `4/4`
- Submitted before soft deadline: yes
- First submission with `90+`: yes
- Assignment-specific bonus: no
- Final result: `4 + 1 + 1 = 6`

### Example 2

- Assignment regular value: `3` points
- Internal mark: `74`
- Converted regular grade: `2/3`
- Submitted before soft deadline: no
- First submission with `90+`: no
- Assignment-specific bonus: `+1`
- Final result: `2 + 1 = 3`

### Example 3

- Assignment regular value: `4` points
- Internal mark: `88`
- Converted regular grade: `3/4`
- Submitted before soft deadline: yes
- First submission with `90+`: no
- Assignment-specific bonus: no
- Final result: `3 + 1 = 4`

### Example 4

- Assignment regular value: `4` points
- Submission time: after hard deadline
- Result: ignored, no points awarded

### Example 5

- Assignment regular value: `4` points
- First evaluated submission internal mark: `91`
- First evaluated submission converted regular grade: `4/4`
- First submission before soft deadline: no
- First submission with `90+`: yes
- Assignment-specific bonus on first evaluation: no
- Student submits one rework attempt
- Final re-evaluation converted regular grade: `4/4`
- Final assignment-specific bonus after re-evaluation: `+1`
- Final result: `4 + 0 + 1 + 1 = 6`
