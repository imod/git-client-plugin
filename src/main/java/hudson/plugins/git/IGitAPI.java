package hudson.plugins.git;

import hudson.model.TaskListener;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.transport.RemoteConfig;
import org.jenkinsci.plugins.gitclient.GitClient;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @deprecated methods here are deprecated until proven useful by a plugin
 */
public interface IGitAPI extends GitClient {

    boolean hasGitModules( String treeIsh ) throws GitException, InterruptedException;
    String getRemoteUrl(String name, String GIT_DIR) throws GitException, InterruptedException;
    void setRemoteUrl(String name, String url, String GIT_DIR) throws GitException, InterruptedException;
    String getDefaultRemote( String _default_ ) throws GitException, InterruptedException;
    boolean isBareRepository() throws GitException, InterruptedException;
    /**
     * Detect whether a repository at the given path is bare or not.
     *
     * @param GIT_DIR The path to the repository (must be to .git dir).
     *
     * @throws GitException
     */
    boolean isBareRepository(String GIT_DIR) throws GitException, InterruptedException;
    void submoduleInit()  throws GitException, InterruptedException;
    void submoduleSync() throws GitException, InterruptedException;
    String getSubmoduleUrl(String name) throws GitException, InterruptedException;
    void setSubmoduleUrl(String name, String url) throws GitException, InterruptedException;
    void fixSubmoduleUrls( String remote, TaskListener listener ) throws GitException, InterruptedException;
    void setupSubmoduleUrls( String remote, TaskListener listener ) throws GitException, InterruptedException;
    public void fetch(String repository, String refspec) throws GitException, InterruptedException;
    void fetch(RemoteConfig remoteRepository) throws InterruptedException;
    void fetch() throws GitException, InterruptedException;
    void reset(boolean hard) throws GitException, InterruptedException;
    void reset() throws GitException, InterruptedException;
    void push(RemoteConfig repository, String revspec) throws GitException, InterruptedException;
    void merge(String revSpec) throws GitException, InterruptedException;
    void clone(RemoteConfig source) throws GitException, InterruptedException;
    void clone(RemoteConfig rc, boolean useShallowClone) throws GitException, InterruptedException;
    List<Branch> getBranchesContaining(String revspec) throws GitException, InterruptedException;
    List<IndexEntry> lsTree(String treeIsh) throws GitException, InterruptedException;
    List<ObjectId> revListBranch(String branchId) throws GitException, InterruptedException;
    String describe(String commitIsh) throws GitException, InterruptedException;
    List<Tag> getTagsOnCommit(String revName) throws GitException, IOException, InterruptedException;
    void changelog(String revFrom, String revTo, OutputStream fos) throws GitException, InterruptedException;
    void checkoutBranch(String branch, String commitish) throws GitException, InterruptedException;
    ObjectId mergeBase(ObjectId sha1, ObjectId sha12) throws InterruptedException;
    String getAllLogEntries(String branch) throws InterruptedException;
    List<String> showRevision(Revision r) throws GitException, InterruptedException;
}
