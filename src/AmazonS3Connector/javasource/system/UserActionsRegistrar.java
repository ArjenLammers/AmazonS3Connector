package system;

import com.mendix.core.actionmanagement.IActionRegistrator;

public class UserActionsRegistrar
{
  public void registerActions(IActionRegistrator registrator)
  {
    registrator.bundleComponentLoaded();
    registrator.registerUserAction(amazons3connector.actions.CopyObject.class);
    registrator.registerUserAction(amazons3connector.actions.DeleteObject.class);
    registrator.registerUserAction(amazons3connector.actions.FindMostRecentObjects.class);
    registrator.registerUserAction(amazons3connector.actions.GetObject.class);
    registrator.registerUserAction(amazons3connector.actions.ListBuckets.class);
    registrator.registerUserAction(amazons3connector.actions.ListObjects.class);
    registrator.registerUserAction(amazons3connector.actions.ListPrefixes.class);
    registrator.registerUserAction(amazons3connector.actions.MoveObject.class);
    registrator.registerUserAction(amazons3connector.actions.PutObject.class);
    registrator.registerUserAction(amazons3connector.actions.SyncRegions.class);
    registrator.registerUserAction(amazons3connector.actions.ValidateConnection.class);
    registrator.registerUserAction(librarylogging.actions.AddLibraryLogListener.class);
    registrator.registerUserAction(librarylogging.actions.InitializeLogging.class);
    registrator.registerUserAction(librarylogging.actions.SetRootLevel.class);
    registrator.registerUserAction(system.actions.VerifyPassword.class);
  }
}
