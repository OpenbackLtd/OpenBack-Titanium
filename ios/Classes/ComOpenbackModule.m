/**
 * OpenBack
 *
 * Created by Your Name
 * Copyright (c) 2018 Your Company. All rights reserved.
 */

#import "ComOpenbackModule.h"
#import "TiBase.h"
#import "TiHost.h"
#import "TiUtils.h"

extern NSString * const _Nonnull kOBKFrameworkVersion;

@implementation ComOpenbackModule

#pragma mark Internal

- (id)moduleGUID {
  return @"caf35bd2-9d6f-4628-b888-f2b6bbf6a0f1";
}

- (NSString *)moduleId {
  return @"com.openback";
}

#pragma mark Lifecycle

- (void)startup {
    [super startup];
    DebugLog(@"[DEBUG] %@ loaded", self);
    [self start:@{ }];
}

#pragma Public APIs

- (void)start:(id)args {
    ENSURE_DICT(args);
    
    NSError *error = nil;
    if ([OpenBack setupWithConfig:args error:&error]) {
        if (![OpenBack start:&error]) {
            DebugLog(@"[DEBUG] start failed: %@", error);
        }
    } else {
        DebugLog(@"[DEBUG] setupWithConfig failed: %@", error);
    }
}

- (void)stop:(id)args {
    NSError *error = nil;
    if (![OpenBack stop:&error]) {
        DebugLog(@"[DEBUG] setupWithConfig failed: %@", error);
    }
}

- (void)coppaCompliant:(id)value {
    ENSURE_SINGLE_ARG(value, NSNumber);
    BOOL compliant = [TiUtils boolValue:value];
    [OpenBack coppaCompliant:compliant];
}

- (void)gdprForgetUser:(id)value {
    ENSURE_SINGLE_ARG(value, NSNumber);
    BOOL forgetUser = [TiUtils boolValue:value];
    
    NSError *error = nil;
    if (![OpenBack gdprForgetUser:forgetUser error:nil]) {
        DebugLog(@"[DEBUG] gdprForgetUser failed: %@", error);
    }
}

- (void)logGoal:(id)args {
    ENSURE_ARG_COUNT(args, 3);
    NSString *goal = [args objectAtIndex:0];
    NSUInteger step = [[args objectAtIndex:1] integerValue];
    double value = [[args objectAtIndex:2] doubleValue];
    
    NSError *error = nil;
    if (![OpenBack logGoal:goal step:step value:value error:&error]) {
        DebugLog(@"[DEBUG] logGoal failed: %@", error);
    }
}

- (void)setCustomTrigger:(id)args {
    ENSURE_ARG_COUNT(args, 2);
    OBKCustomTriggerType trigger = [[args objectAtIndex:0] integerValue];
    id value = [args objectAtIndex:1];
    
    NSError *error = nil;
    if (![OpenBack setValue:value forCustomTrigger:trigger error:&error]) {
        DebugLog(@"[DEBUG] setCustomTrigger failed: %@", error);
    }
}

- (void)setUserInfo:(id)args {
    ENSURE_DICT(args);
    NSError *error = nil;
    if (![OpenBack setUserInfo:args error:&error]) {
        DebugLog(@"[DEBUG] setUserInfo failed: %@", error);
    }
}

- (NSString *)version {
    return kOBKFrameworkVersion;
}

#pragma Constants

MAKE_SYSTEM_PROP(CUSTOM_TRIGGER_1, kOBKCustomTrigger1);
MAKE_SYSTEM_PROP(CUSTOM_TRIGGER_2, kOBKCustomTrigger2);
MAKE_SYSTEM_PROP(CUSTOM_TRIGGER_3, kOBKCustomTrigger3);
MAKE_SYSTEM_PROP(CUSTOM_TRIGGER_4, kOBKCustomTrigger4);
MAKE_SYSTEM_PROP(CUSTOM_TRIGGER_5, kOBKCustomTrigger5);
MAKE_SYSTEM_PROP(CUSTOM_TRIGGER_6, kOBKCustomTrigger6);
MAKE_SYSTEM_PROP(CUSTOM_TRIGGER_7, kOBKCustomTrigger7);
MAKE_SYSTEM_PROP(CUSTOM_TRIGGER_8, kOBKCustomTrigger8);
MAKE_SYSTEM_PROP(CUSTOM_TRIGGER_9, kOBKCustomTrigger9);
MAKE_SYSTEM_PROP(CUSTOM_TRIGGER_10, kOBKCustomTrigger10);

@end
