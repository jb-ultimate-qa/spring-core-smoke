package com.mytests.spring.core.springview;

import org.springframework.stereotype.Service;

/**
 * Throwaway bean for the Spring View live-update case.
 * <p>
 * Deliberately referenced by nothing: that case renames and deletes this class, and a
 * rename is a refactoring across files. Every other bean in this project is a source
 * anchor for a Spring. Core or Spring. Core. IDE UX case - renaming one would break
 * whichever case references it, even if the change is later undone.
 * <p>
 * Do not inject this anywhere, and do not add members that other cases could anchor on.
 */
@Service
public class ViewTarget {
}
