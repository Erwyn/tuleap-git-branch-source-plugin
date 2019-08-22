package org.jenkinsci.plugins.tuleap_git_branch_source;

import hudson.model.TaskListener;
import jenkins.scm.api.SCMHeadObserver;
import jenkins.scm.api.SCMSource;
import jenkins.scm.api.SCMSourceCriteria;
import jenkins.scm.api.trait.SCMSourceContext;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

public class TuleapSCMSourceContext extends SCMSourceContext<TuleapSCMSourceContext, TuleapSCMSourceRequest> {

    /**
     * {@code true} if the {@link TuleapSCMSourceRequest} will need information about branches.
     */
    private boolean wantBranches = false;

    public TuleapSCMSourceContext(@CheckForNull SCMSourceCriteria criteria, @Nonnull SCMHeadObserver observer) {
        super(criteria, observer);
    }

    @Nonnull
    @Override
    public TuleapSCMSourceRequest newRequest(@Nonnull SCMSource scmSource, @CheckForNull TaskListener taskListener) {
        return new TuleapSCMSourceRequest(scmSource, this, taskListener);
    }

    /**
     * Returns {@code true} if the {@link TuleapSCMSourceRequest} will need information about branches.
     *
     * @return {@code true} if the {@link TuleapSCMSourceRequest} will need information about branches.
     */
    public final boolean wantBranches() {
        return wantBranches;
    }

    /**
     * Adds a requirement for branch details to any {@link TuleapSCMSourceContext} for this context.
     *
     * @param include
     *            {@code true} to add the requirement or {@code false} to leave the requirement as is (makes simpler
     *            with method chaining)
     * @return {@code this} for method chaining.
     */
    @Nonnull
    public TuleapSCMSourceContext wantBranches(boolean include) {
        wantBranches = wantBranches || include;
        return this;
    }

}
